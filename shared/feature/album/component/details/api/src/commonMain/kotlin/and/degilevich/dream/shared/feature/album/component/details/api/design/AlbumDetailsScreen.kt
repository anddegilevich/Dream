package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .statusBarsPadding()
        )
        AlbumIcon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(260.dp),
            iconUrl = state.iconUrl,
        )
        Space(height = 16.dp)
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = state.name,
            color = Theme.colors.text.primary
        )
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .navigationBarsPadding()
        )
    }
}