package and.degilevich.dream.shared.feature.search.ui.api.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.preview.SearchCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun SearchCard(
    data: SearchCardUIData,
    onClick: (id: Identifier) -> Unit,
    modifier: Modifier = Modifier
) {
    when (data) {
        is AlbumSearchCardUIData -> {
            AlbumSearchCard(
                modifier = modifier,
                data = data,
                onClick = onClick
            )
        }

        is ArtistSearchCardUIData -> {
            ArtistSearchCard(
                modifier = modifier,
                data = data,
                onClick = onClick
            )
        }

        is TrackSearchCardUIData -> {
            TrackSearchCard(
                modifier = modifier,
                data = data,
                onClick = onClick
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun SearchCardPreview(
    @PreviewParameter(SearchCardUIDataPreviewProvider::class)
    data: SearchCardUIData
) = ComposeAppTheme {
    SearchCard(
        modifier = Modifier.themeBackground(),
        data = data,
        onClick = { }
    )
}