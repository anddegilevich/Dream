package and.degilevich.dream.shared.app.api.compose

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.compose.ext.showToast
import and.degilevich.dream.shared.compose.design.snackbar.DreamSnackbar
import and.degilevich.dream.shared.compose.theme.api.DreamTheme
import and.degilevich.dream.shared.compose.theme.api.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DreamApp(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        rootComponent.toasts.collect { toast ->
            snackBarHostState.showToast(toast)
        }
    }

    DreamTheme(
        isDarkMode = isSystemInDarkTheme()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Theme.colors.background),
        ) {
            DreamScreens(
                screens = rootComponent.screenStack
            )
            SnackbarHost(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding(),
                hostState = snackBarHostState
            ) { snackbarData ->
                DreamSnackbar(
                    modifier = Modifier.padding(16.dp),
                    data = snackbarData
                )
            }
        }
    }
}