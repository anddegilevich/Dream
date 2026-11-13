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
import and.degilevich.dream.shared.resource.api.ResourceManager
import dev.icerock.moko.resources.StringResource

internal class ServiceExceptionToMessageMapperImpl(
    private val resourceManager: ResourceManager
) : ServiceExceptionToMessageMapper {

    override fun map(item: ServiceException): String {
        return mapStatusToResource(status = item.status)
            ?.let(resourceManager::getString)
            ?: item.serviceMessage
            ?: resourceManager.getString(Res.strings.error)
    }

    private fun mapStatusToResource(status: ServiceErrorStatus): StringResource? {
        return when (status) {
            ServiceErrorStatus.UNAUTHORIZED -> Res.strings.error_session_expired
            ServiceErrorStatus.FORBIDDEN -> Res.strings.error_action_not_allowed
            ServiceErrorStatus.NOT_FOUND -> Res.strings.error_not_found
            ServiceErrorStatus.TOO_MANY_REQUESTS -> Res.strings.error_too_many_requests
            ServiceErrorStatus.INTERNAL_SERVER_ERROR,
            ServiceErrorStatus.BAD_GATEWAY,
            ServiceErrorStatus.SERVICE_UNAVAILABLE -> Res.strings.error_service_unavailable
            ServiceErrorStatus.BAD_REQUEST,
            ServiceErrorStatus.UNKNOWN -> null
        }
    }
}
