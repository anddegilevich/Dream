package and.degilevich.dream.shared.feature.search.design.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.provider.SearchCardUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.ui.tooling.preview.PreviewParameter

@Composable
fun SearchCard(
    data: SearchCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: Identifier) -> Unit
) {
    when (data) {
        is AlbumSearchCardUIData -> {
            AlbumSearchCard(
                modifier = modifier,
                data = data,
                onClicked = onClicked
            )
        }

        is ArtistSearchCardUIData -> {
            ArtistSearchCard(
                modifier = modifier,
                data = data,
                onClicked = onClicked
            )
        }

        is TrackSearchCardUIData -> {
            TrackSearchCard(
                modifier = modifier,
                data = data,
                onClicked = onClicked
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun SearchCardPreview(
    @PreviewParameter(SearchCardUIDataPreviewProvider::class)
    data: SearchCardUIData
) = ComposeAppTheme {
    SearchCard(
        modifier = Modifier.themeBackground(),
        data = data
    ) { }
}