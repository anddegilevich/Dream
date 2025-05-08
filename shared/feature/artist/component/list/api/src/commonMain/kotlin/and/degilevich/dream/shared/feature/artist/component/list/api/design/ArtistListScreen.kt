package and.degilevich.dream.shared.feature.artist.component.list.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistCard
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
    val profileIconInteractionSource = remember { MutableInteractionSource() }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .themeBackground(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(all = 16.dp)
            .plus(
                WindowInsets.navigationBars
                    .add(WindowInsets.statusBars)
                    .asPaddingValues()
            )
    ) {
        item {
            Icon(
                modifier = Modifier
                    .scaleOnClick(interactionSource = profileIconInteractionSource)
                    .clickableWithDebounce(
                        interactionSource = profileIconInteractionSource
                    ) {
                        onIntent(ArtistListIntent.OnProfileClicked)
                    }
                    .size(64.dp),
                painter = painterResource(Res.images.ic_duck),
                tint = Theme.colors.brandGreen,
                contentDescription = null,
            )
        }
        item {
            Text(
                text = stringResource(Res.strings.title_artists),
                color = Theme.colors.textPrimary
            )
            Text(
                text = state.artistCount,
                color = Theme.colors.textSecondary
            )
        }
        items(
            items = state.artists,
            key = { item -> item.id }
        ) { item ->
            ArtistCard(
                state = item,
                onCardClicked = { id ->
                    onIntent(ArtistListIntent.OnArtistClicked(id))
                }
            )
        }
    }
}