package and.degilevich.dream.shared.feature.artist.design.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonArtistLabel(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(all = 4.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(size = 24.dp)
        )
        Space(width = 8.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 120.dp,
                    height = 16.dp
                )
        )
    }
}