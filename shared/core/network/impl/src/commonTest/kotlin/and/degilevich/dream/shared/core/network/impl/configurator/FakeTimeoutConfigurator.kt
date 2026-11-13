package and.degilevich.dream.shared.core.network.impl.configurator

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.HttpClientConfig

internal class FakeTimeoutConfigurator(
    private val onConfigure: (HttpClientConfig<*>) -> Unit = { fakeImplementationError() }
) : TimeoutConfigurator {

    override fun configure(config: HttpClientConfig<*>) = onConfigure(config)
}
