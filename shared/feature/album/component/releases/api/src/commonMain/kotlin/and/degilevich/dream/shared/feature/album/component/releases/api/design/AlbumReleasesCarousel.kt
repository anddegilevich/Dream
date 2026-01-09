package and.degilevich.dream.shared.feature.album.component.releases.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumCard
import and.degilevich.dream.shared.feature.album.design.api.design.skeleton.SkeletonAlbumCard
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun AlbumReleasesCarousel(
    state: AlbumReleasesUIState,
    modifier: Modifier = Modifier,
    onIntent: (AlbumReleasesIntent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(Res.strings.title_new_releases),
            color = Theme.colors.text.primary,
            style = Theme.typography.h1
        )
        Space(8.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            identifiedSkeletonItems(
                skeleton = state.releases,
                loadingItemsCount = 10,
                loadingItemContent = {
                    SkeletonAlbumCard()
                },
                itemContent = { album ->
                    AlbumCard(
                        modifier = Modifier.animateItem(),
                        data = album
                    ) { id ->
                        onIntent(
                            AlbumReleasesIntent.OnAlbumClicked(id = id)
                        )
                    }
                }
            )
        }
    }
}