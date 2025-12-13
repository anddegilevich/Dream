package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@PreviewLightDark
@Composable
private fun IconButtonPreview() {
    ComposeAppTheme {
        IconButton(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.images.ic_back)
        ) { }
    }
}