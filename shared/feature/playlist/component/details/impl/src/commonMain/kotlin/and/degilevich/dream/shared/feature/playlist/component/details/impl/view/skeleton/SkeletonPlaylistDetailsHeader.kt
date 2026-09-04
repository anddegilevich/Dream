package and.degilevich.dream.shared.feature.playlist.component.details.impl.view.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeBackground
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
fun SkeletonPlaylistDetailsHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        Spacer(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .themeShimmer()
                .size(size = 200.dp)
        )
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 140.dp,
                    height = 24.dp
                )
        )
    }
}

@LightDarkPreviews
@Composable
private fun SkeletonPlaylistDetailsHeaderPreview() = ComposeAppTheme {
    SkeletonPlaylistDetailsHeader(
        modifier = Modifier.themeBackground()
    )
}
