package and.degilevich.dream.shared.core.service.api.exception

import io.ktor.http.HttpStatusCode

enum class ServiceErrorStatus(val code: Int) {
    BAD_REQUEST(HttpStatusCode.BadRequest.value),
    UNAUTHORIZED(HttpStatusCode.Unauthorized.value),
    FORBIDDEN(HttpStatusCode.Forbidden.value),
    NOT_FOUND(HttpStatusCode.NotFound.value),
    TOO_MANY_REQUESTS(HttpStatusCode.TooManyRequests.value),
    INTERNAL_SERVER_ERROR(HttpStatusCode.InternalServerError.value),
    BAD_GATEWAY(HttpStatusCode.BadGateway.value),
    SERVICE_UNAVAILABLE(HttpStatusCode.ServiceUnavailable.value),
    UNKNOWN(-1)
}
