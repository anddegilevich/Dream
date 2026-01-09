package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ArtistLabel(
    data: ArtistLabelUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: Identifier) -> Unit
) {
    Row(
        modifier = modifier
            .clickableWithDebounce {
                onClicked(data.id)
            }
            .padding(all = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ArtistIcon(
            modifier = Modifier.size(24.dp),
            iconUrl = data.iconUrl,
        )
        Space(width = 8.dp)
        Text(
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h4
        )
    }
}