package and.degilevich.dream.shared.core.client.api

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse

interface RemoteClient {

    suspend fun getCatching(
        block: HttpRequestBuilder.() -> Unit
    ): Result<HttpResponse>

    suspend fun postCatching(
        block: HttpRequestBuilder.() -> Unit
    ): Result<HttpResponse>
}