package and.degilevich.dream.shared.core.network.api.ext

import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> Result<HttpResponse>.foldBody(): Result<T> {
    return this.foldResult { response ->
        runCatching { response.body<T>() }
    }
}