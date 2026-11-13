package and.degilevich.dream.shared.core.network.impl

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.configurator.ContentNegotiationConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.LoggingConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.NetworkErrorConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.TimeoutConfigurator
import and.degilevich.dream.shared.core.network.impl.engine.ClientEngineFactory
import io.ktor.client.HttpClient

internal class RemoteClientImpl(
    clientEngineFactory: ClientEngineFactory,
    private val loggingConfigurator: LoggingConfigurator,
    private val contentNegotiationConfigurator: ContentNegotiationConfigurator,
    private val timeoutConfigurator: TimeoutConfigurator,
    private val networkErrorConfigurator: NetworkErrorConfigurator
) : RemoteClient {

    override val client: HttpClient = HttpClient(
        engine = clientEngineFactory.create()
    ) {
        apply(loggingConfigurator::configure)
        apply(contentNegotiationConfigurator::configure)
        apply(timeoutConfigurator::configure)
        apply(networkErrorConfigurator::configure)
        expectSuccess = true
    }
}