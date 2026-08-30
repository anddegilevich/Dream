package and.degilevich.dream.shared.feature.common.component.drawer.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.PrimaryTextButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerIntent
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerUIState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.preview.DrawerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.drawer.impl.view.semantic.AppDrawerSemantic
import and.degilevich.dream.shared.feature.common.component.drawer.impl.view.skeleton.SkeletonDrawerHeader
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun AppDrawer(
    state: DrawerUIState,
    modifier: Modifier = Modifier,
    onIntent: (DrawerIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(all = 24.dp)
    ) {
        SkeletonCrossfade(
            skeleton = state.user,
            loadingContent = {
                SkeletonDrawerHeader(
                    modifier = Modifier.testTag(AppDrawerSemantic.TEST_TAG_HEADER_SKELETON)
                )
            }
        ) { user ->
            DrawerHeader(data = user)
        }
        Space(height = 32.dp)
        PrimaryTextButton(
            modifier = Modifier
                .testTag(AppDrawerSemantic.TEST_TAG_LOGOUT_BUTTON)
                .fillMaxWidth(),
            text = stringResource(Res.strings.button_logout)
        ) {
            onIntent(DrawerIntent.OnLogoutClicked)
        }
    }
}

@LightDarkPreviews
@Composable
private fun AppDrawerPreview(
    @PreviewParameter(DrawerUIStatePreviewProvider::class)
    state: DrawerUIState
) = ComposeAppTheme {
    AppDrawer(
        state = state
    ) { }
}
