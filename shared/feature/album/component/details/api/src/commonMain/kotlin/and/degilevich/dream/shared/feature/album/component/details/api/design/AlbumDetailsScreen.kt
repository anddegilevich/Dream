package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlbumDetailsScreen(
    state: AlbumDetailsUIState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .themeBackground()
            .padding(16.dp),
    ) {
        Text(
            text = state.name,
            color = Theme.colors.textPrimary
        )
    }
}