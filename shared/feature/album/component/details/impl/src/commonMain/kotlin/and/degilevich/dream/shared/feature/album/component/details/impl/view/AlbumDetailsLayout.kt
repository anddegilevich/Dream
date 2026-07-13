package and.degilevich.dream.shared.feature.album.component.details.impl.view

import and.degilevich.dream.shared.design.system.divider.TextCircleDivider
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.feature.album.component.details.impl.preview.AlbumDetailsLayoutUIDataPreviewProvider
import and.degilevich.dream.shared.feature.album.component.details.impl.view.semantic.AlbumDetailsLayoutSemantic
import and.degilevich.dream.shared.feature.album.ui.api.view.AlbumIcon
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun AlbumDetailsLayout(
    data: AlbumDetailsLayoutUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        AlbumIcon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(260.dp),
            iconUrl = data.iconUrl,
        )
        Space(height = 40.dp)
        Text(
            modifier = Modifier.testTag(AlbumDetailsLayoutSemantic.TEST_TAG_NAME),
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h2
        )
        Space(height = 12.dp)
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = data.type,
                color = Theme.colors.text.secondary,
                style = Theme.typography.label
            )
            TextCircleDivider(
                color = Theme.colors.text.secondary
            )
            Text(
                text = data.year,
                color = Theme.colors.text.secondary,
                style = Theme.typography.label
            )
        }
    }
}

@LightDarkPreviews
@Composable
private fun AlbumDetailsLayoutPreview(
    @PreviewParameter(AlbumDetailsLayoutUIDataPreviewProvider::class)
    data: AlbumDetailsLayoutUIData
) = ComposeAppTheme {
    AlbumDetailsLayout(
        modifier = Modifier.themeBackground(),
        data = data
    )
}