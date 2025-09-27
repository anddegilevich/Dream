package and.degilevich.dream.shared.app.api.design

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.design.ext.showToast
import and.degilevich.dream.shared.app.api.design.screen.ComposeScreens
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.snackbar.AppSnackbarHost
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.foundation.decompose.compose.component.collectState
import and.degilevich.dream.shared.foundation.decompose.compose.slot.AnimatedSlot
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun ComposeApp(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val navbarSlot by rootComponent.navbar.subscribeAsState()

    LaunchedEffect(Unit) {
        rootComponent.toasts.collect { toast ->
            snackBarHostState.showToast(toast)
        }
    }

    ComposeAppTheme(
        isDarkMode = isSystemInDarkTheme()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .themeBackground(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ComposeScreens(
                    modifier = Modifier.weight(1f),
                    screens = rootComponent.screenStack
                )
                AnimatedSlot(
                    slot = navbarSlot,
                    enter = slideInVertically { it },
                    exit = slideOutVertically { it }
                ) { child ->
                    val component = child.instance

                    AppNavbar(
                        modifier = Modifier.navigationBarsPadding(),
                        state = component.collectState(),
                        onIntent = component::handleIntent
                    )
                }
            }
            AppSnackbarHost(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .navigationBarsPadding(),
                hostState = snackBarHostState
            )
        }
    }
}