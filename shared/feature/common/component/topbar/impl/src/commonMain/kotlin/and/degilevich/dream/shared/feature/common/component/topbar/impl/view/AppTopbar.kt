package and.degilevich.dream.shared.feature.common.component.topbar.impl.view

import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarIntent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarUIState
import and.degilevich.dream.shared.feature.common.component.topbar.impl.preview.TopbarUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.topbar.impl.view.semantic.AppTopbarSemantic
import and.degilevich.dream.shared.feature.user.ui.api.view.UserAvatar
import and.degilevich.dream.shared.feature.user.ui.api.view.skeleton.SkeletonUserAvatar
import and.degilevich.dream.shared.foundation.compose.click.rememberDebounced
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun AppTopbar(
    state: TopbarUIState,
    modifier: Modifier = Modifier,
    onIntent: (TopbarIntent) -> Unit
) {
    val onAvatarClicked = rememberDebounced { onIntent(TopbarIntent.OnAvatarClicked) }

    Column(
        modifier = modifier
            .themeBackground()
            .statusBarsPadding()
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SkeletonCrossfade(
                skeleton = state.avatar,
                loadingContent = {
                    SkeletonUserAvatar(
                        modifier = Modifier.testTag(AppTopbarSemantic.TEST_TAG_AVATAR_SKELETON),
                    )
                }
            ) { avatar ->
                UserAvatar(
                    modifier = Modifier
                        .testTag(AppTopbarSemantic.TEST_TAG_AVATAR)
                        .clip(CircleShape)
                        .clickable(
                            interactionSource = null,
                            indication = themeRipple(),
                            onClick = onAvatarClicked
                        ),
                    data = avatar,
                    size = 36.dp
                )
            }
        }
        Spacer(
            modifier = Modifier
                .background(Theme.colors.common.line)
                .height(1.dp)
                .fillMaxWidth()
        )
    }
}

@LightDarkPreviews
@Composable
private fun AppTopbarPreview(
    @PreviewParameter(TopbarUIStatePreviewProvider::class)
    state: TopbarUIState
) = ComposeAppTheme {
    AppTopbar(
        state = state
    ) { }
}
