package and.degilevich.dream.shared.app.impl.view

import and.degilevich.dream.shared.app.impl.component.child.Screen
import and.degilevich.dream.shared.app.impl.view.ext.showToast
import and.degilevich.dream.shared.app.impl.view.screen.ComposeScreens
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.snackbar.AppSnackbarHost
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

@Composable
internal fun ComposeApp(
    screens: Value<ChildStack<ScreenConfig, Screen>>,
    toasts: Flow<ToastData>,
    modifier: Modifier = Modifier
) {
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        toasts.collect { toast ->
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
                screens = screens
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
