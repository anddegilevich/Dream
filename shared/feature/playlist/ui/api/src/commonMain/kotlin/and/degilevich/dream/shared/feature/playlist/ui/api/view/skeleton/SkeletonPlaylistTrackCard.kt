package and.degilevich.dream.shared.feature.playlist.ui.api.view.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonPlaylistTrackCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 28.dp,
                    height = 16.dp
                )
        )
        Spacer(
            modifier = Modifier
                .themeShimmer()
                .size(size = 48.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(space = 4.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .roundedThemeShimmer()
                    .size(
                        width = 120.dp,
                        height = 16.dp
                    )
            )
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

@LightDarkPreviews
@Composable
private fun SkeletonPlaylistTrackCardPreview() = ComposeAppTheme {
    SkeletonPlaylistTrackCard(
        modifier = Modifier.themeBackground()
    )
}
