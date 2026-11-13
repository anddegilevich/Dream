package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.logger.ClientLogger
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

internal class LoggingConfiguratorImpl : LoggingConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.install(Logging) {
            logger = ClientLogger(clientKClass = RemoteClient::class)
            level = LogLevel.BODY
        }
    }
}
