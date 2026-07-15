package and.degilevich.dream.shared.core.network.api

import io.ktor.client.HttpClient

interface RemoteClient {
    val client: HttpClient
}