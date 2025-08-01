package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoCardUIData
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ArtistInfoCard(
    data: ArtistInfoCardUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtistIcon(
                modifier = Modifier
                    .size(120.dp),
                iconUrl = data.iconUrl
            )
            Space(width = 20.dp)
            Text(
                text = data.name,
                color = Theme.colors.text.primary,
                style = Theme.typography.h2
            )
        }
    }
}