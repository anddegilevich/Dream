package and.degilevich.dream.shared.feature.artist.component.list.api.compose

import and.degilevich.dream.shared.compose.foundation.ext.Space
import and.degilevich.dream.shared.compose.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.compose.view.ArtistCard
import and.degilevich.dream.shared.resource.Res
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ArtistListScreen(
    state: ArtistListUIState,
    onIntent: (ArtistListIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.background)
            .safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(65.dp),
            painter = painterResource(Res.images.ic_duck),
            tint = Theme.colors.brandGreen,
            contentDescription = null,
        )
        Space(height = 16.dp)
        Text(
            text = stringResource(Res.strings.title_artists),
            color = Theme.colors.textPrimary
        )
        Text(
            text = state.artistCount,
            color = Theme.colors.textSecondary
        )
        Space(height = 16.dp)
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = state.artists,
                key = { item -> item.id }
            ) { item ->
                ArtistCard(
                    item = item,
                    onCardClicked = { id ->
                        onIntent(ArtistListIntent.OnArtistClicked(id))
                    }
                )
            }
        }
    }
}