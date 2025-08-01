package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.shared.design.system.divider.TextCircleDivider
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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