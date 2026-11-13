package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

internal class ContentNegotiationConfiguratorImpl : ContentNegotiationConfigurator {

    override fun configure(config: HttpClientConfig<*>) {
        config.install(ContentNegotiation) {
            json(json = JsonSerialFormat.json)
        }
    }
}
