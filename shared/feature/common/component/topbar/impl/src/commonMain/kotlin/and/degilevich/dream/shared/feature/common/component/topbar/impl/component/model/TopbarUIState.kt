package and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model

import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable

@Immutable
data class TopbarUIState(
    val avatar: Skeleton<UserAvatarUIData>
) {

    companion object : EmptyFactory<TopbarUIState> {

        override fun empty(): TopbarUIState {
            return TopbarUIState(
                avatar = Skeleton.Loading
            )
        }
    }
}
