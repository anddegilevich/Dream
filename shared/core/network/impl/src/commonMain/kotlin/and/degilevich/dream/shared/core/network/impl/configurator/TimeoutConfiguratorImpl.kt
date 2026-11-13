package and.degilevich.dream.shared.core.network.impl.configurator

import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import kotlin.time.Duration.Companion.seconds

internal class TimeoutConfiguratorImpl : TimeoutConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.install(HttpTimeout) {
            connectTimeoutMillis = TIMEOUT.inWholeMilliseconds
            socketTimeoutMillis = TIMEOUT.inWholeMilliseconds
        }
    }

    private companion object {
        val TIMEOUT = 30.seconds
    }
}
