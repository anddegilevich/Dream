package and.degilevich.dream.shared.core.service.impl.network

import and.degilevich.dream.shared.core.service.api.exception.ServiceErrorStatus
import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import kotlin.test.Test

class ServiceResponseErrorConfiguratorImplTest {

    @Test
    fun `request - documented error status - throws service exception with matching status`() = runTest {
        val documented = ServiceErrorStatus.entries - ServiceErrorStatus.UNKNOWN

        documented.forEach { status ->
            val error = shouldThrow<ServiceException> {
                createClient(engine = spotifyError(code = status.code, message = "message-${status.code}")).get(URL)
            }

            error.status shouldBe status
        }
    }

    @Test
    fun `request - spotify error body - exposes the spotify message`() = runTest {
        val error = shouldThrow<ServiceException> {
            createClient(
                engine = spotifyError(code = 403, message = "Player command failed: Premium required")
            ).get(URL)
        }

        error.serviceMessage shouldBe "Player command failed: Premium required"
    }

    @Test
    fun `request - undocumented error status - throws service exception with unknown status`() = runTest {
        val error = shouldThrow<ServiceException> {
            createClient(engine = spotifyError(code = 418, message = "teapot")).get(URL)
        }

        error.status shouldBe ServiceErrorStatus.UNKNOWN
    }

    @Test
    fun `request - error body is not spotify json - throws service exception without message`() = runTest {
        val engine = MockEngine {
            respond(content = "<html>Bad Gateway</html>", status = HttpStatusCode.BadGateway)
        }

        val error = shouldThrow<ServiceException> {
            createClient(engine = engine).get(URL)
        }

        error.status shouldBe ServiceErrorStatus.BAD_GATEWAY
        error.serviceMessage shouldBe null
    }

    @Test
    fun `request - error status - keeps the response exception as cause`() = runTest {
        val error = shouldThrow<ServiceException> {
            createClient(engine = spotifyError(code = 404, message = "Not found")).get(URL)
        }

        error.cause.shouldBeInstanceOf<ResponseException>()
    }

    @Test
    fun `request - success status - returns the response`() = runTest {
        val engine = MockEngine { respond(content = "ok", status = HttpStatusCode.OK) }

        val body = createClient(engine = engine).get(URL).bodyAsText()

        body shouldBe "ok"
    }

    @Test
    fun `request - transport failure - rethrows it unchanged`() = runTest {
        val failure = IOException("connection refused")

        val error = shouldThrow<IOException> {
            createClient(engine = MockEngine { throw failure }).get(URL)
        }

        error shouldBe failure
    }

    private fun createClient(engine: MockEngine): HttpClient {
        return HttpClient(engine = engine) {
            ServiceResponseErrorConfiguratorImpl().configure(config = this)
            expectSuccess = true
        }
    }

    private fun spotifyError(
        code: Int,
        message: String
    ): MockEngine = MockEngine {
        respond(
            content = """{"error":{"status":$code,"message":"$message"}}""",
            status = HttpStatusCode.fromValue(code),
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private companion object {
        const val URL = "https://api.test/endpoint"
    }
}
