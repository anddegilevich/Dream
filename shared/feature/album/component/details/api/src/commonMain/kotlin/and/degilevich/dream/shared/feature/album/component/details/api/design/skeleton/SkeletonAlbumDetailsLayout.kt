package and.degilevich.dream.shared.feature.album.component.details.api.design.skeleton

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
fun SkeletonAlbumDetailsLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .themeShimmer()
                .size(size = 260.dp)
        )
        Space(height = 40.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 140.dp,
                    height = 24.dp
                )
        )
        Space(height = 12.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 160.dp,
                    height = 12.dp
                )
        )
    }
}