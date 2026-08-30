package and.degilevich.dream.shared.feature.playlist.ui.api.view.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonPlaylistCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Spacer(
            modifier = Modifier
                .themeShimmer()
                .size(size = 140.dp)
        )
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 132.dp,
                    height = 16.dp
                )
        )
    }
}

@LightDarkPreviews
@Composable
private fun SkeletonPlaylistCardPreview() = ComposeAppTheme {
    SkeletonPlaylistCard()
}
