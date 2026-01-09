package and.degilevich.dream.shared.feature.search.design.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import and.degilevich.dream.shared.feature.search.design.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
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
fun ArtistSearchCard(
    data: ArtistSearchCardUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: Identifier) -> Unit
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
        ArtistIcon(
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
            Text(
                text = stringResource(Res.strings.label_artist),
                color = Theme.colors.text.secondary,
                style = Theme.typography.label,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}