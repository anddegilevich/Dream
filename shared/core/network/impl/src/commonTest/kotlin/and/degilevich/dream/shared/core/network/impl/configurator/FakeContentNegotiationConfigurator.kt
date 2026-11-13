package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.HttpClientConfig

internal class FakeContentNegotiationConfigurator(
    private val onConfigure: (HttpClientConfig<*>) -> Unit = { fakeImplementationError() }
) : ContentNegotiationConfigurator {

    override fun configure(config: HttpClientConfig<*>) = onConfigure(config)
}
