package and.degilevich.dream.shared.core.client.api

import io.ktor.client.HttpClient

interface RemoteClient {
    val client: HttpClient
}