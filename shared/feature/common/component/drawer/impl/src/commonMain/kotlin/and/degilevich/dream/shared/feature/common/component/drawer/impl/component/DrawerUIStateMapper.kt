package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerUIState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerHeaderUIData
import and.degilevich.dream.shared.feature.user.ui.api.mapper.UserDataToAvatarUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class DrawerUIStateMapper : Mapper<DrawerState, DrawerUIState>, KoinComponent {

    private val userDataToAvatarUIDataMapper: UserDataToAvatarUIDataMapper by inject()

    override fun map(item: DrawerState): DrawerUIState = with(item) {
        DrawerUIState(
            user = Skeleton.from(
                isLoading = user.isEmpty()
            ) {
                DrawerHeaderUIData(
                    avatar = userDataToAvatarUIDataMapper.map(user),
                    name = user.displayName
                )
            }
        )
    }
}
