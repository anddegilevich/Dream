package and.degilevich.dream.shared.core.network.impl.configurator

import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.plugins.HttpTimeoutCapability
import io.ktor.client.plugins.HttpTimeoutConfig
import io.ktor.client.request.get
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class TimeoutConfiguratorImplTest {

    @Test
    fun `configure - always - applies 30s connect and socket timeouts to requests`() = runTest {
        var timeout: HttpTimeoutConfig? = null
        val client = HttpClient(
            engine = MockEngine { request ->
                timeout = request.getCapabilityOrNull(HttpTimeoutCapability)
                respondOk()
            }
        ) {
            TimeoutConfiguratorImpl().configure(config = this)
        }

        client.get(URL)

        timeout?.connectTimeoutMillis shouldBe EXPECTED_TIMEOUT_MILLIS
        timeout?.socketTimeoutMillis shouldBe EXPECTED_TIMEOUT_MILLIS
    }

    private companion object {
        const val URL = "https://api.test/endpoint"
        const val EXPECTED_TIMEOUT_MILLIS = 30_000L
    }
}
