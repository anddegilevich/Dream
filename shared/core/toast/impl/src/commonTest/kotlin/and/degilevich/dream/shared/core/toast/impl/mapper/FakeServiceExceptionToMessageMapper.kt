package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeServiceExceptionToMessageMapper(
    private val onMap: (ServiceException) -> String = { fakeImplementationError() }
) : ServiceExceptionToMessageMapper {

    override fun map(item: ServiceException): String = onMap(item)
}
