package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.core.network.api.exception.NetworkTimeoutException
import and.degilevich.dream.shared.core.network.api.exception.NoNetworkConnectionException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import kotlin.test.Test

class NetworkErrorConfiguratorImplTest {

    @Test
    fun `request - request timeout - throws network timeout exception`() = runTest {
        val timeout = HttpRequestTimeoutException(url = URL, timeoutMillis = 1_000L)

        val error = shouldThrow<NetworkTimeoutException> {
            createClient(engine = MockEngine { throw timeout }).get(URL)
        }

        error.cause shouldBe timeout
    }

    @Test
    fun `request - connect timeout - throws network timeout exception`() = runTest {
        val timeout = ConnectTimeoutException(message = "connect timeout")

        val error = shouldThrow<NetworkTimeoutException> {
            createClient(engine = MockEngine { throw timeout }).get(URL)
        }

        error.cause shouldBe timeout
    }

    @Test
    fun `request - socket timeout - throws network timeout exception`() = runTest {
        val timeout = SocketTimeoutException(message = "socket timeout")

        val error = shouldThrow<NetworkTimeoutException> {
            createClient(engine = MockEngine { throw timeout }).get(URL)
        }

        error.cause shouldBe timeout
    }

    @Test
    fun `request - io failure - throws no network connection exception`() = runTest {
        val failure = IOException("connection refused")

        val error = shouldThrow<NoNetworkConnectionException> {
            createClient(engine = MockEngine { throw failure }).get(URL)
        }

        error.cause shouldBe failure
    }

    @Test
    fun `request - non io failure - rethrows it unchanged`() = runTest {
        val failure = IllegalStateException("unexpected")

        val error = shouldThrow<IllegalStateException> {
            createClient(engine = MockEngine { throw failure }).get(URL)
        }

        error shouldBe failure
    }

    @Test
    fun `request - error status - leaves the response exception unchanged`() = runTest {
        val engine = MockEngine { respond(content = "", status = HttpStatusCode.NotFound) }

        val error = shouldThrow<Exception> {
            createClient(engine = engine).get(URL)
        }

        error.shouldBeInstanceOf<ResponseException>()
    }

    private fun createClient(engine: MockEngine): HttpClient {
        return HttpClient(engine = engine) {
            NetworkErrorConfiguratorImpl().configure(config = this)
            expectSuccess = true
        }
    }

    private companion object {
        const val URL = "https://api.test/endpoint"
    }
}
