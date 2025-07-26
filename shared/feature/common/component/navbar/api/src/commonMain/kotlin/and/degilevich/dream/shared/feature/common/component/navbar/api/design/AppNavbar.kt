package and.degilevich.dream.shared.feature.common.component.navbar.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier

@Composable
fun AppNavbar(
    state: NavbarUIState,
    modifier: Modifier = Modifier,
    onIntent: (NavbarIntent) -> Unit
) {
    Row(
        modifier = modifier
            .themeBackground()
            .fillMaxWidth()
    ) {
        state.items.forEach { item ->
            key(item.id) {
                NavbarItemButton(
                    modifier = Modifier.weight(1f),
                    data = item
                ) {
                    onIntent(NavbarIntent.OnItemClicked(item.id))
                }
            }
        }
    }
}