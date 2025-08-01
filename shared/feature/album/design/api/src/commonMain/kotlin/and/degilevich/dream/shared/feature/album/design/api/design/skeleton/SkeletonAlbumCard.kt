package and.degilevich.dream.shared.feature.album.design.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonAlbumCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .themeShimmer()
                .size(size = 140.dp),
        )
        Space(height = 4.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 132.dp,
                    height = 20.dp
                ),
        )
        Space(height = 2.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 100.dp,
                    height = 16.dp
                ),
        )
    }
}