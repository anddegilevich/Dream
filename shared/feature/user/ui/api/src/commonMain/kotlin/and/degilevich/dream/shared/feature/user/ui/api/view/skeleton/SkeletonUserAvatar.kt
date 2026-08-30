package and.degilevich.dream.shared.feature.user.ui.api.view.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonUserAvatar(
    size: Dp,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .themeShimmer()
    )
}

@LightDarkPreviews
@Composable
private fun SkeletonUserAvatarPreview() = ComposeAppTheme {
    SkeletonUserAvatar(
        modifier = Modifier.themeBackground(),
        size = 36.dp
    )
}
