package and.degilevich.dream.shared.core.service.impl.network

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.HttpClientConfig

internal class FakeServiceRequestRetryConfigurator(
    private val onConfigure: (HttpClientConfig<*>) -> Unit = { fakeImplementationError() }
) : ServiceRequestRetryConfigurator {

    override fun configure(config: HttpClientConfig<*>) = onConfigure(config)
}
