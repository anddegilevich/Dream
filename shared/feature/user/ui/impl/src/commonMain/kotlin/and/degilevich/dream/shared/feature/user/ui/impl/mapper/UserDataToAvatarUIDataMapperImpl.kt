package and.degilevich.dream.shared.feature.user.ui.impl.mapper

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.feature.user.ui.api.mapper.UserDataToAvatarUIDataMapper
import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData

internal class UserDataToAvatarUIDataMapperImpl : UserDataToAvatarUIDataMapper {

    override fun map(item: UserData): UserAvatarUIData = with(item) {
        UserAvatarUIData(
            url = images.firstOrNull()?.url.orEmpty(),
            firstLetter = displayName.trim().firstOrNull()?.uppercase().orEmpty()
        )
    }
}
