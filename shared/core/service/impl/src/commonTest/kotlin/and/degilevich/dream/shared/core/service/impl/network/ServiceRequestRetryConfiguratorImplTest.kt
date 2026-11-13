package and.degilevich.dream.shared.core.service.impl.network

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.longs.shouldBeInRange
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class ServiceRequestRetryConfiguratorImplTest {

    @Test
    fun `get - 429 then 200 - retries and returns success`() = runTest {
        val engine = engineResponding(
            tooManyRequests(),
            ok()
        )

        val status = createClient(engine = engine).get(URL).status

        status shouldBe HttpStatusCode.OK
        engine.requestHistory shouldHaveSize 2
    }

    @Test
    fun `post - 429 then 200 - retries and returns success`() = runTest {
        val engine = engineResponding(
            tooManyRequests(),
            ok()
        )

        val status = createClient(engine = engine).post(URL).status

        status shouldBe HttpStatusCode.OK
        engine.requestHistory shouldHaveSize 2
    }

    @Test
    fun `get - 429 with Retry-After - waits at least Retry-After before retrying`() = runTest {
        val engine = engineResponding(
            tooManyRequests(retryAfterSeconds = 5),
            ok()
        )

        createClient(engine = engine).get(URL)

        currentTime shouldBeInRange 5_000L..6_000L
    }

    @Test
    fun `get - 429 with Retry-After at cap - retries`() = runTest {
        val engine = engineResponding(
            tooManyRequests(retryAfterSeconds = 30),
            ok()
        )

        val status = createClient(engine = engine).get(URL).status

        status shouldBe HttpStatusCode.OK
        engine.requestHistory shouldHaveSize 2
        currentTime shouldBeInRange 30_000L..31_000L
    }

    @Test
    fun `get - 429 with Retry-After above cap - fails without retrying`() = runTest {
        val engine = engineResponding(
            tooManyRequests(retryAfterSeconds = 31),
            ok()
        )

        val error = shouldThrow<ResponseException> {
            createClient(engine = engine).get(URL)
        }

        error.response.status shouldBe HttpStatusCode.TooManyRequests
        engine.requestHistory shouldHaveSize 1
        currentTime shouldBe 0L
    }

    @Test
    fun `get - repeated 429 without Retry-After - waits grow exponentially`() = runTest {
        val requestTimes = mutableListOf<Long>()
        val engine = engineResponding(
            tooManyRequests(),
            tooManyRequests(),
            tooManyRequests(),
            ok(),
            onRequest = { requestTimes.add(currentTime) }
        )

        createClient(engine = engine).get(URL)

        val waits = requestTimes.zipWithNext { previous, next -> next - previous }
        waits shouldHaveSize 3
        waits[0] shouldBeGreaterThan 0L
        waits[1] shouldBeGreaterThan waits[0]
        waits[2] shouldBeGreaterThan waits[1]
    }

    @Test
    fun `get - 429 on every attempt - fails with 429 after 3 retries`() = runTest {
        val engine = engineResponding(
            tooManyRequests(),
            tooManyRequests(),
            tooManyRequests(),
            tooManyRequests(),
            ok()
        )

        val error = shouldThrow<ResponseException> {
            createClient(engine = engine).get(URL)
        }

        error.response.status shouldBe HttpStatusCode.TooManyRequests
        engine.requestHistory shouldHaveSize 4
    }

    @Test
    fun `get - 401 - fails without retrying`() = runTest {
        assertNotRetried(status = HttpStatusCode.Unauthorized)
    }

    @Test
    fun `get - 404 - fails without retrying`() = runTest {
        assertNotRetried(status = HttpStatusCode.NotFound)
    }

    @Test
    fun `get - 500 - fails without retrying`() = runTest {
        assertNotRetried(status = HttpStatusCode.InternalServerError)
    }

    @Test
    fun `get - 503 - fails without retrying`() = runTest {
        assertNotRetried(status = HttpStatusCode.ServiceUnavailable)
    }

    private suspend fun TestScope.assertNotRetried(status: HttpStatusCode) {
        val engine = engineResponding(
            StubResponse(status = status),
            ok()
        )

        val error = shouldThrow<ResponseException> {
            createClient(engine = engine).get(URL)
        }

        error.response.status shouldBe status
        engine.requestHistory shouldHaveSize 1
        currentTime shouldBe 0L
    }

    private fun createClient(engine: MockEngine): HttpClient {
        return HttpClient(engine = engine) {
            ServiceRequestRetryConfiguratorImpl().configure(config = this)
            expectSuccess = true
        }
    }

    private fun engineResponding(
        vararg responses: StubResponse,
        onRequest: () -> Unit = {}
    ): MockEngine {
        var index = 0
        return MockEngine {
            onRequest()
            val response = responses[index++]
            respond(
                content = "",
                status = response.status,
                headers = response.headers
            )
        }
    }

    private fun tooManyRequests(retryAfterSeconds: Int? = null): StubResponse {
        return StubResponse(
            status = HttpStatusCode.TooManyRequests,
            headers = retryAfterSeconds?.let { seconds ->
                headersOf(HttpHeaders.RetryAfter, seconds.toString())
            } ?: Headers.Empty
        )
    }

    private fun ok(): StubResponse = StubResponse(status = HttpStatusCode.OK)

    private class StubResponse(
        val status: HttpStatusCode,
        val headers: Headers = Headers.Empty
    )

    private companion object {
        const val URL = "https://api.test/endpoint"
    }
}
