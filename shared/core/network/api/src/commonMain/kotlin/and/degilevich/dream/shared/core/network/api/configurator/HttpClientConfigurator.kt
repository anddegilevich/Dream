package and.degilevich.dream.shared.core.network.api.configurator

import io.ktor.client.HttpClientConfig

interface HttpClientConfigurator {
    fun configure(config: HttpClientConfig<*>)
}
