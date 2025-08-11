package and.degilevich.dream.shared.foundation.compose.snackbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDismissSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SnackbarData) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val dismissState: DismissState = rememberDismissState()
    var isVisibleSnackbar by remember { mutableStateOf(false) }

    LaunchedEffect(dismissState.currentValue) {
        val isDismissed = dismissState.currentValue != DismissValue.Default
        if (isDismissed) {
            hostState.currentSnackbarData?.dismiss()
        }
    }
    LaunchedEffect(
        hostState.currentSnackbarData,
        dismissState.currentValue
    ) {
        val isResetedDismissState = dismissState.currentValue == DismissValue.Default
        val shouldShowSnackbar = hostState.currentSnackbarData != null
        isVisibleSnackbar = isResetedDismissState && shouldShowSnackbar
    }

    SnackbarHost(
        modifier = modifier,
        hostState = hostState
    ) { snackbarData ->
        SwipeToDismiss(
            state = dismissState,
            background = { },
        ) {
            AnimatedVisibility(
                visible = isVisibleSnackbar,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                snackbar(snackbarData)
                DisposableEffect(Unit) {
                    onDispose {
                        coroutineScope.launch {
                            dismissState.reset()
                        }
                    }
                }
            }
        }
    }
}