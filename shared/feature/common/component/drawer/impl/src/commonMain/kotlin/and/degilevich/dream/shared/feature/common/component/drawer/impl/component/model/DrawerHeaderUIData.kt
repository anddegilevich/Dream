package and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model

import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class DrawerHeaderUIData(
    val avatar: UserAvatarUIData,
    val name: String
) {

    companion object : EmptyFactory<DrawerHeaderUIData> {

        override fun empty(): DrawerHeaderUIData {
            return DrawerHeaderUIData(
                avatar = UserAvatarUIData.empty(),
                name = ""
            )
        }
    }
}
