package and.degilevich.dream.shared.core.service.impl.network

import and.degilevich.dream.shared.core.network.api.RemoteClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal fun fakeRemoteClient(engine: MockEngine): RemoteClient = object : RemoteClient {

    override val client: HttpClient = HttpClient(engine = engine) {
        install(ContentNegotiation) {
            json(
                json = Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        expectSuccess = true
    }
}
