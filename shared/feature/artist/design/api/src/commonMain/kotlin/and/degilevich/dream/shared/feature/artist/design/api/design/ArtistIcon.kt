package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun ArtistIcon(
    iconUrl: String,
    modifier: Modifier = Modifier
) {
    val placeholderPainter = painterResource(Res.images.ic_duck)

    AsyncImage(
        modifier = modifier
            .clip(CircleShape)
            .background(Theme.colors.iconPlaceholderBackground),
        model = iconUrl,
        placeholder = placeholderPainter,
        error = placeholderPainter,
        fallback = placeholderPainter,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}