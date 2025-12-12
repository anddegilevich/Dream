package and.degilevich.dream.shated.feature.track.design.api.preview.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.DayNightPreviews
import and.degilevich.dream.shated.feature.track.design.api.design.skeleton.SkeletonTrackCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@DayNightPreviews
@Composable
private fun SkeletonTrackCardPreview() {
    ComposeAppTheme {
        SkeletonTrackCard(
            modifier = Modifier.themeBackground()
        )
    }
}