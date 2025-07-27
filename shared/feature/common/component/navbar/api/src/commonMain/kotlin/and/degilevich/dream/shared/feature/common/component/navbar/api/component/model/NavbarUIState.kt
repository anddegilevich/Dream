package and.degilevich.dream.shared.feature.common.component.navbar.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class NavbarUIState(
    val items: ImmutableList<NavbarItemUIData>
) {
    companion object : EmptyFactory<NavbarUIState> {
        override fun empty(): NavbarUIState {
            return NavbarUIState(
                items = persistentListOf()
            )
        }
    }
}