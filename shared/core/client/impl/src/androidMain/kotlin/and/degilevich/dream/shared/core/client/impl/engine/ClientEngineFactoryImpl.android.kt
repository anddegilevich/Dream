package and.degilevich.dream.shared.core.client.impl.engine

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual class ClientEngineFactoryImpl : ClientEngineFactory {
    override fun create(): HttpClientEngine {
        return OkHttp.create()
    }
}