package and.degilevich.dream.shared.design.system.button

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Preview
@Composable
private fun IconButtonDarkPreview() {
    ComposeAppTheme(
        isDarkMode = true
    ) {
        IconButton(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.images.ic_back)
        ) { }
    }
}

@Preview
@Composable
private fun IconButtonLightPreview() {
    ComposeAppTheme(
        isDarkMode = false
    ) {
        IconButton(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.images.ic_back)
        ) { }
    }
}