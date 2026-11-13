package and.degilevich.dream.shared.core.network.impl.engine

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import io.ktor.client.engine.HttpClientEngine

internal class FakeClientEngineFactory(
    private val onCreate: () -> HttpClientEngine = { fakeImplementationError() }
) : ClientEngineFactory {

    override fun create(): HttpClientEngine = onCreate()
}
