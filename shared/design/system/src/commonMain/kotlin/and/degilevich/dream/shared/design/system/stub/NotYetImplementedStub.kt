package and.degilevich.dream.shared.design.system.stub

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ViewStub(
    modifier: Modifier = Modifier,
    stub: String = stringResource(Res.strings.stub_not_yet_implemented)
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(
                color = Theme.colors.common.line,
                width = 1.dp
            )
            .themeBackground(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stub,
            color = Theme.colors.text.primary,
            style = Theme.typography.h2
        )
    }
}

@LightDarkPreviews
@Composable
private fun ViewStubPreview() = ComposeAppTheme {
    ViewStub(stub = "Stub")
}
