package and.degilevich.dream.shared.core.network.impl.configurator

import io.kotest.matchers.nulls.shouldNotBeNull
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.pluginOrNull
import kotlin.test.Test

class LoggingConfiguratorImplTest {

    @Test
    fun `configure - always - installs the logging plugin`() {
        val client = HttpClient(engine = MockEngine { respondOk() }) {
            LoggingConfiguratorImpl().configure(config = this)
        }

        client.pluginOrNull(Logging).shouldNotBeNull()
    }
}
