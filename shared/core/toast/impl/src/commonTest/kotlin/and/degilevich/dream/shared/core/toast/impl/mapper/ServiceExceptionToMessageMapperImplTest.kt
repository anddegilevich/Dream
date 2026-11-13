package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.Res
import and.degilevich.dream.error
import and.degilevich.dream.error_action_not_allowed
import and.degilevich.dream.error_not_found
import and.degilevich.dream.error_service_unavailable
import and.degilevich.dream.error_session_expired
import and.degilevich.dream.error_too_many_requests
import and.degilevich.dream.shared.core.service.api.exception.ServiceErrorStatus
import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.resource.test.FakeResourceManager
import dev.icerock.moko.resources.StringResource
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ServiceExceptionToMessageMapperImplTest {

    @Test
    fun `map - unauthorized service error - shows session expired`() {
        messageFor(error = serviceError(status = ServiceErrorStatus.UNAUTHORIZED)) shouldBe "session-expired"
    }

    @Test
    fun `map - forbidden service error - shows action not allowed`() {
        messageFor(error = serviceError(status = ServiceErrorStatus.FORBIDDEN)) shouldBe "action-not-allowed"
    }

    @Test
    fun `map - not found service error - shows not found`() {
        messageFor(error = serviceError(status = ServiceErrorStatus.NOT_FOUND)) shouldBe "not-found"
    }

    @Test
    fun `map - too many requests service error - shows too many requests`() {
        messageFor(error = serviceError(status = ServiceErrorStatus.TOO_MANY_REQUESTS)) shouldBe "too-many-requests"
    }

    @Test
    fun `map - server side service error - shows service unavailable`() {
        val serverStatuses = listOf(
            ServiceErrorStatus.INTERNAL_SERVER_ERROR,
            ServiceErrorStatus.BAD_GATEWAY,
            ServiceErrorStatus.SERVICE_UNAVAILABLE
        )

        serverStatuses.forEach { status ->
            messageFor(error = serviceError(status = status)) shouldBe "service-unavailable"
        }
    }

    @Test
    fun `map - bad request service error - shows the spotify message`() {
        val error = serviceError(status = ServiceErrorStatus.BAD_REQUEST, serviceMessage = "Invalid base62 id")

        messageFor(error = error) shouldBe "Invalid base62 id"
    }

    @Test
    fun `map - unknown service error without message - shows generic error`() {
        val error = serviceError(status = ServiceErrorStatus.UNKNOWN, serviceMessage = null)

        messageFor(error = error) shouldBe "generic-error"
    }

    private fun messageFor(error: ServiceException): String {
        return createMapper().map(item = error)
    }

    private fun serviceError(
        status: ServiceErrorStatus,
        serviceMessage: String? = "spotify-message"
    ): ServiceException {
        return ServiceException(
            status = status,
            serviceMessage = serviceMessage,
            cause = IllegalStateException("response")
        )
    }

    private fun createMapper(): ServiceExceptionToMessageMapperImpl {
        val strings: Map<StringResource, String> = mapOf(
            Res.strings.error to "generic-error",
            Res.strings.error_session_expired to "session-expired",
            Res.strings.error_action_not_allowed to "action-not-allowed",
            Res.strings.error_not_found to "not-found",
            Res.strings.error_too_many_requests to "too-many-requests",
            Res.strings.error_service_unavailable to "service-unavailable"
        )
        return ServiceExceptionToMessageMapperImpl(
            resourceManager = FakeResourceManager(onGetString = { resource -> strings.getValue(resource) })
        )
    }
}
