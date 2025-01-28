package and.degilevich.dream.shared.feature.artist.compose.view

import and.degilevich.dream.shared.compose.foundation.ext.Space
import and.degilevich.dream.shared.feature.artist.compose.model.ArtistUIItem
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ArtistCard(
    item: ArtistUIItem,
    modifier: Modifier = Modifier,
    onCardClicked: (String) -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onCardClicked(item.id)
            }
            .background(
                color = Color.Gray
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black)
                .size(64.dp)
        )
        Space(height = 8.dp)
        Text(
            modifier = Modifier.widthIn(max = 100.dp),
            text = item.name,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}