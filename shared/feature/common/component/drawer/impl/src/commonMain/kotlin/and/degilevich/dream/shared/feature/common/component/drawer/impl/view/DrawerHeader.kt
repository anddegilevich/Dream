package and.degilevich.dream.shared.feature.common.component.drawer.impl.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerHeaderUIData
import and.degilevich.dream.shared.feature.common.component.drawer.impl.preview.DrawerHeaderUIDataPreviewProvider
import and.degilevich.dream.shared.feature.common.component.drawer.impl.view.semantic.AppDrawerSemantic
import and.degilevich.dream.shared.feature.user.ui.api.view.UserAvatar
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp

@Composable
fun DrawerHeader(
    data: DrawerHeaderUIData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        UserAvatar(
            modifier = Modifier.testTag(AppDrawerSemantic.TEST_TAG_AVATAR),
            data = data.avatar,
            size = 72.dp
        )
        Text(
            modifier = Modifier.testTag(AppDrawerSemantic.TEST_TAG_NAME),
            text = data.name,
            color = Theme.colors.text.primary,
            style = Theme.typography.h3
        )
    }
}

@LightDarkPreviews
@Composable
private fun DrawerHeaderPreview(
    @PreviewParameter(DrawerHeaderUIDataPreviewProvider::class)
    data: DrawerHeaderUIData
) = ComposeAppTheme {
    DrawerHeader(
        modifier = Modifier.themeBackground(),
        data = data
    )
}