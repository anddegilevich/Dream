package and.degilevich.dream.shared.feature.common.component.drawer.impl.view.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.user.ui.api.view.skeleton.SkeletonUserAvatar
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonDrawerHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SkeletonUserAvatar(modifier = Modifier.size(72.dp))
        Spacer(
            modifier = Modifier
                .roundedThemeShimmer()
                .size(
                    width = 120.dp,
                    height = 20.dp
                )
        )
    }
}

@LightDarkPreviews
@Composable
private fun SkeletonDrawerHeaderPreview() = ComposeAppTheme {
    SkeletonDrawerHeader(
        modifier = Modifier.themeBackground()
    )
}
