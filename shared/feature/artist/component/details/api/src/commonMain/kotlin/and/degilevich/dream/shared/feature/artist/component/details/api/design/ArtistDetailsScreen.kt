package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.system.button.PrimaryButton
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistCard
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ArtistDetailsScreen(
    state: ArtistDetailsUIState,
    onIntent: (ArtistDetailsIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArtistIcon(
            modifier = Modifier.size(200.dp),
            iconUrl = state.artistIconUrl
        )
        Space(height = 12.dp)
        Text(
            text = state.artistName,
            color = Theme.colors.textPrimary
        )
        Space(height = 32.dp)
        Text(
            text = stringResource(Res.strings.title_similar_artists),
            color = Theme.colors.textPrimary
        )
        Space(height = 12.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            reverseLayout = true,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(
                items = state.similarArtists,
                key = { item -> item.id }
            ) { item ->
                ArtistCard(
                    state = item,
                    onCardClicked = { id ->
                        onIntent(ArtistDetailsIntent.OnSimilarArtistClicked(id))
                    }
                )
            }
        }
        Space(height = 16.dp)
        PrimaryButton(
            text = stringResource(Res.strings.button_back)
        ) {
            onIntent(ArtistDetailsIntent.OnBackCLicked)
        }
    }
}