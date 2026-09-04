package and.degilevich.dream.shared.feature.playlist.component.details.impl.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsHeaderUIData
import and.degilevich.dream.shared.feature.playlist.component.details.impl.preview.PlaylistDetailsHeaderUIDataPreviewProvider
import and.degilevich.dream.shared.feature.playlist.component.details.impl.view.semantic.PlaylistDetailsScreenSemantic
import and.degilevich.dream.shared.feature.playlist.ui.api.view.PlaylistIcon
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun PlaylistDetailsHeader(
    data: PlaylistDetailsHeaderUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        PlaylistIcon(
            modifier = Modifier
                .testTag(PlaylistDetailsScreenSemantic.TEST_TAG_COVER)
                .align(Alignment.CenterHorizontally)
                .size(200.dp),
            iconUrl = data.coverUrl
        )
        Text(
            modifier = Modifier.testTag(PlaylistDetailsScreenSemantic.TEST_TAG_NAME),
            text = data.name,
            style = Theme.typography.h2,
            color = Theme.colors.text.primary
        )
        if (data.isVisibleDescription) {
            Text(
                modifier = Modifier.testTag(PlaylistDetailsScreenSemantic.TEST_TAG_DESCRIPTION),
                text = data.description,
                style = Theme.typography.label,
                color = Theme.colors.text.secondary
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun PlaylistDetailsHeaderPreview(
    @PreviewParameter(PlaylistDetailsHeaderUIDataPreviewProvider::class)
    data: PlaylistDetailsHeaderUIData
) = ComposeAppTheme {
    PlaylistDetailsHeader(
        modifier = Modifier.themeBackground(),
        data = data
    )
}
