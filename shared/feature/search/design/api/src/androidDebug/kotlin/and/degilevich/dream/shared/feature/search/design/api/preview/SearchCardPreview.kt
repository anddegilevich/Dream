package and.degilevich.dream.shared.feature.search.design.api.preview

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.search.design.api.design.SearchCard
import and.degilevich.dream.shared.feature.search.design.api.model.card.SearchCardUIData
import and.degilevich.dream.shared.feature.search.design.api.preview.provider.SearchCardUIDataPreviewProvider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter

@PreviewLightDark
@Composable
private fun SearchCardPreview(
    @PreviewParameter(SearchCardUIDataPreviewProvider::class)
    data: SearchCardUIData
) {
    ComposeAppTheme {
        SearchCard(
            modifier = Modifier.themeBackground(),
            data = data
        ) { }
    }
}