package and.degilevich.dream.shared.feature.track.component.details.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonTrackDetailsInfoLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .roundedThemeShimmer()
                .size(
                    width = 80.dp,
                    height = 20.dp
                )
        )
        Space(height = 20.dp)
        Spacer(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .themeShimmer()
                .fillMaxWidth()
                .aspectRatio(1f)

        )
        Space(height = 48.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    height = 32.dp,
                    width = 160.dp
                )
        )
        Space(height = 4.dp)
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    height = 24.dp,
                    width = 120.dp
                )
        )
    }
}