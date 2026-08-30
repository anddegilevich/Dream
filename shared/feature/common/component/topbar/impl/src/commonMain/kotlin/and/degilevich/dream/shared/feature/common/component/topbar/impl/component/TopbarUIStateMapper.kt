package and.degilevich.dream.shared.feature.common.component.topbar.impl.component

import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarState
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarUIState
import and.degilevich.dream.shared.feature.user.ui.api.mapper.UserDataToAvatarUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class TopbarUIStateMapper : Mapper<TopbarState, TopbarUIState>, KoinComponent {

    private val userDataToAvatarUIDataMapper: UserDataToAvatarUIDataMapper by inject()

    override fun map(item: TopbarState): TopbarUIState = with(item) {
        TopbarUIState(
            avatar = Skeleton.from(
                isLoading = user.isEmpty()
            ) {
                user.let(userDataToAvatarUIDataMapper::map)
            }
        )
    }
}
