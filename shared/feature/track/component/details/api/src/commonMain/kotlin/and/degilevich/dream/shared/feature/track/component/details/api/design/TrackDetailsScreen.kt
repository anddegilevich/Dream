package and.degilevich.dream.shared.feature.track.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun TrackDetailsScreen(
    state: TrackDetailsUIState,
    modifier: Modifier = Modifier,
    onIntent: (TrackDetailsIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        Spacer(
            modifier = Modifier
                .padding(top = 12.dp)
                .statusBarsPadding()
        )
        IconButton(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.images.ic_back)
        ) {
            onIntent(TrackDetailsIntent.OnBackClicked)
        }
        Space(height = 20.dp)
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 40.dp),
            text = state.album,
            style = Theme.typography.label,
            color = Theme.colors.text.primary
        )
        Space(height = 20.dp)
        AlbumIcon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .aspectRatio(1f),
            iconUrl = state.albumIconUrl,
        )
        Space(height = 48.dp)
        Text(
            text = state.name,
            style = Theme.typography.h2,
            color = Theme.colors.text.primary
        )
        Space(height = 4.dp)
        Text(
            text = state.artists,
            style = Theme.typography.main,
            color = Theme.colors.text.secondary
        )
        Spacer(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .navigationBarsPadding()
        )
    }
}