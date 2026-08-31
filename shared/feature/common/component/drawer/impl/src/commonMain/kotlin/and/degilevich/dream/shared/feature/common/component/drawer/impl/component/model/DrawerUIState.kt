package and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable

@Immutable
data class DrawerUIState(
    val user: Skeleton<DrawerHeaderUIData>
) {

    companion object : EmptyFactory<DrawerUIState> {

        override fun empty(): DrawerUIState {
            return DrawerUIState(
                user = Skeleton.Loading
            )
        }
    }
}
