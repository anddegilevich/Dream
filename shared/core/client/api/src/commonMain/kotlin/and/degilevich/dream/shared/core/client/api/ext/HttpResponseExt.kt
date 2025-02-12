package and.degilevich.dream.shared.core.client.api.ext

import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import and.degilevich.dream.shared.foundation.primitive.result.foldTry
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> Result<HttpResponse>.foldResponse(): Result<T> {
    return this.foldResult { response ->
        foldTry { response.body<T>() }
    }
}