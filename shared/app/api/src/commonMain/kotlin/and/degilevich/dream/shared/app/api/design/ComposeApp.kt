package and.degilevich.dream.shared.app.api.design

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.design.ext.showToast
import and.degilevich.dream.shared.app.api.design.screen.ComposeScreens
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.snackbar.AppSnackbarHost
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ComposeApp(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        rootComponent.toasts.collect { toast ->
            snackBarHostState.showToast(toast)
        }
    }

    ComposeAppTheme {
        Box(
            modifier = modifier
                .fillMaxSize()
                .themeBackground(),
        ) {
            ComposeScreens(
                modifier = Modifier.fillMaxSize(),
                screens = rootComponent.screenStack
            )
            AppSnackbarHost(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding(),
                hostState = snackBarHostState
            )
        }
    }
}