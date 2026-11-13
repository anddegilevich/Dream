package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal interface ServiceExceptionToMessageMapper : Mapper<ServiceException, String>
