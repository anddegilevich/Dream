package and.degilevich.dream.shared.core.network.impl.engine

import io.ktor.client.engine.HttpClientEngine

internal interface ClientEngineFactory {
    fun create(): HttpClientEngine
}