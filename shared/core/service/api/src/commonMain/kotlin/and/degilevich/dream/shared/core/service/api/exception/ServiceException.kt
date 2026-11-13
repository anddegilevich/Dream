package and.degilevich.dream.shared.core.service.api.exception

class ServiceException(
    val status: ServiceErrorStatus,
    val serviceMessage: String?,
    cause: Throwable
) : Exception(serviceMessage, cause)
