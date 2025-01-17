//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.core.client.impl.engine

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

internal actual class ClientEngineFactoryImpl : ClientEngineFactory {
    override fun create(): HttpClientEngine {
        return Darwin.create()
    }
}