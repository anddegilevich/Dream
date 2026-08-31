package and.degilevich.dream.shared.feature.user.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PrivateUserObject
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface UserOutputToDataMapper : Mapper<PrivateUserObject, UserData>
