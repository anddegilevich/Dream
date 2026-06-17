package and.degilevich.dream.shared.core.client.api.ext

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse

suspend fun HttpClient.getCatching(
    block: HttpRequestBuilder.() -> Unit
): Result<HttpResponse> = runCatching { get(block) }

suspend fun HttpClient.postCatching(
    block: HttpRequestBuilder.() -> Unit
): Result<HttpResponse> = runCatching { post(block) }