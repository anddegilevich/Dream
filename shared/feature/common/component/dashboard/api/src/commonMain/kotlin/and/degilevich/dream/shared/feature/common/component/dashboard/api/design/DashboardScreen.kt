package and.degilevich.dream.shared.feature.common.component.dashboard.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardIntent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import and.degilevich.dream.shared.foundation.compose.ext.plus
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DashboardScreen(
    state: DashboardUIState,
    onIntent: (DashboardIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .themeBackground()
            .fillMaxSize(),
        contentPadding = WindowInsets.statusBars.asPaddingValues()
            .plus(WindowInsets.navigationBars.asPaddingValues())
            .plus(WindowInsets.navigationBars.asPaddingValues())
    ) {
        item {
            AlbumReleasesCarousel(
                state = state.albumReleasesCarousel,
                onIntent = { intent ->
                    onIntent(
                        DashboardIntent.OnAlbumReleasesIntent(intent = intent)
                    )
                }
            )
        }
    }
}