package and.degilevich.dream.shated.feature.track.design.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonTrackCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top
    ) {
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 12.dp,
                    height = 24.dp
                )
        )
        Space(width = 8.dp)
        Column {
            Spacer(
                modifier = Modifier
                    .roundedThemeShimmer()
                    .size(
                        width = 120.dp,
                        height = 24.dp
                    )
            )
            Space(height = 4.dp)
            Spacer(
                modifier = Modifier
                    .roundedThemeShimmer()
                    .size(
                        width = 80.dp,
                        height = 12.dp
                    )
            )
        }
    }
}