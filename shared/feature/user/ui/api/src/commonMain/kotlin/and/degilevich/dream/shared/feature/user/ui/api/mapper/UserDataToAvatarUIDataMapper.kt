package and.degilevich.dream.shared.feature.user.ui.api.mapper

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface UserDataToAvatarUIDataMapper : Mapper<UserData, UserAvatarUIData>
