package and.degilevich.dream.shared.app.api.compose

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.compose.ext.showToast
import and.degilevich.dream.shared.design.system.snackbar.DreamSnackbar
import and.degilevich.dream.shared.design.theme.api.DreamTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.filepicker.FilePicker
import and.degilevich.dream.shared.foundation.filepicker.state.rememberFilePickerState
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
    val filePickerState = rememberFilePickerState()

    LaunchedEffect(Unit) {
        rootComponent.toasts.collect { toast ->
            snackBarHostState.showToast(toast)
        }
    }
    LaunchedEffect(Unit) {
        rootComponent.filePickerRequests.collect { request ->
            filePickerState.launch(request)
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

    FilePicker(
        state = filePickerState,
        onResult = rootComponent::handleFilePickerResult
    )
}