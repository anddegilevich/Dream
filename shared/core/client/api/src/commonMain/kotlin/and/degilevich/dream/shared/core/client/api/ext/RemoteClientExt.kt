package and.degilevich.dream.shared.core.client.api.ext

import and.degilevich.dream.shared.core.client.api.RemoteClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse

suspend inline fun RemoteClient.safeGet(
    block: HttpRequestBuilder.() -> Unit
): Result<HttpResponse> {
    return runCatching { client.get(block) }
}

suspend inline fun RemoteClient.safePost(
    block: HttpRequestBuilder.() -> Unit
): Result<HttpResponse> {
    return runCatching { client.post(block) }
}