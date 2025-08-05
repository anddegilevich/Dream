package and.degilevich.dream.shared.feature.artist.design.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun ArtistIconPlaceholder(
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier
            .background(color = Theme.colors.icon.placeholderBackground)
            .graphicsLayer(
                scaleX = ICON_FRACTION,
                scaleY = ICON_FRACTION
            ),
        painter = painterResource(Res.images.ic_duck),
        contentDescription = null,
        tint = Theme.colors.icon.secondary,
    )
}

private const val ICON_FRACTION = 0.6f