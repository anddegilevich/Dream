package and.degilevich.dream.shared.design.system.snackbar

import and.degilevich.dream.shared.foundation.compose.snackbar.SwipeToDismissSnackbarHost
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SwipeToDismissSnackbarHost(
        modifier = modifier,
        hostState = hostState
    ) { snackbarData ->
        AppSnackbar(
            modifier = Modifier.padding(16.dp),
            data = snackbarData
        )
    }
}