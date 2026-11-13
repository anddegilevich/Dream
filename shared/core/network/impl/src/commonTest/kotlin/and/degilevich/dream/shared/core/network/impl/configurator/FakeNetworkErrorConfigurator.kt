package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.HttpClientConfig

internal class FakeNetworkErrorConfigurator(
    private val onConfigure: (HttpClientConfig<*>) -> Unit = { fakeImplementationError() }
) : NetworkErrorConfigurator {

    override fun configure(config: HttpClientConfig<*>) = onConfigure(config)
}
