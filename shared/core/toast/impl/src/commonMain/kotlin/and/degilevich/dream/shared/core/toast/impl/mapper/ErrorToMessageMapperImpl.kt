package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.Res
import and.degilevich.dream.error
import and.degilevich.dream.error_no_connection
import and.degilevich.dream.error_timeout
import and.degilevich.dream.shared.core.network.api.exception.NetworkTimeoutException
import and.degilevich.dream.shared.core.network.api.exception.NoNetworkConnectionException
import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.resource.api.ResourceManager

internal class ErrorToMessageMapperImpl(
    private val resourceManager: ResourceManager,
    private val serviceExceptionToMessageMapper: ServiceExceptionToMessageMapper
) : ErrorToMessageMapper {

    override fun map(item: Throwable): String {
        return when (item) {
            is ServiceException -> serviceExceptionToMessageMapper.map(item = item)
            is NetworkTimeoutException -> resourceManager.getString(Res.strings.error_timeout)
            is NoNetworkConnectionException -> resourceManager.getString(Res.strings.error_no_connection)
            else -> item.message ?: resourceManager.getString(Res.strings.error)
        }
    }
}
