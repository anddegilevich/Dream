package and.degilevich.dream.shared.feature.search.design.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.divider.TextCircleDivider
import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.album.design.api.design.AlbumIcon
import and.degilevich.dream.shared.feature.search.design.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun TrackSearchCard(
    data: TrackSearchCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {
    Row(
        modifier = modifier
            .clickableWithDebounce(
                indication = themeRipple()
            ) {
                onClicked(data.id)
            }
            .padding(all = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AlbumIcon(
            modifier = Modifier.size(40.dp),
            iconUrl = data.iconUrl
        )
        Space(8.dp)
        Column {
            Text(
                text = data.name,
                color = Theme.colors.text.primary,
                style = Theme.typography.main,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Space(4.dp)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.strings.label_track),
                    color = Theme.colors.text.secondary,
                    style = Theme.typography.label,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Space(4.dp)
                TextCircleDivider(
                    color = Theme.colors.text.secondary
                )
                Space(4.dp)
                Text(
                    text = data.artistName,
                    color = Theme.colors.text.secondary,
                    style = Theme.typography.label,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}