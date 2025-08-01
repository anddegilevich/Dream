package and.degilevich.dream.shared.feature.track.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsInfoLayoutUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TrackDetailsInfoLayout(
    data: TrackDetailsInfoLayoutUIData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 40.dp),
            text = data.album,
            style = Theme.typography.label,
            color = Theme.colors.text.primary
        )
        Space(height = 20.dp)
        AlbumIcon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .aspectRatio(1f),
            iconUrl = data.albumIconUrl,
        )
        Space(height = 48.dp)
        Text(
            text = data.name,
            style = Theme.typography.h2,
            color = Theme.colors.text.primary
        )
        Space(height = 4.dp)
        Text(
            text = data.artists,
            style = Theme.typography.main,
            color = Theme.colors.text.secondary
        )
    }
}