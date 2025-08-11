package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.design.system.button.PrimaryButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Preview
@Composable
fun AppSnackbarHostPreview() {
    var toastCount by remember { mutableIntStateOf(0) }
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    ComposeAppTheme(isDarkMode = true) {
        Box(
            modifier = Modifier
                .themeBackground()
                .fillMaxSize()
        ) {
            PrimaryButton(
                modifier = Modifier.align(Alignment.Center),
                text = "Show toast"
            ) {
                coroutineScope.launch {
                    toastCount += 1
                    snackBarHostState.showSnackbar(
                        message = "Toast $toastCount",
                        duration = SnackbarDuration.Short,
                        actionLabel = "Action"
                    )
                }
            }

            AppSnackbarHost(
                modifier = Modifier.align(Alignment.BottomCenter),
                hostState = snackBarHostState
            )
        }
    }
}