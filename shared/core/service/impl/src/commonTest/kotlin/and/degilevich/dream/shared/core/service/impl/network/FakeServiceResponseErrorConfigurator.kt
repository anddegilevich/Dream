package and.degilevich.dream.shared.core.service.impl.network

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.HttpClientConfig

internal class FakeServiceResponseErrorConfigurator(
    private val onConfigure: (HttpClientConfig<*>) -> Unit = { fakeImplementationError() }
) : ServiceResponseErrorConfigurator {

    override fun configure(config: HttpClientConfig<*>) = onConfigure(config)
}
