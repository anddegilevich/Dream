package and.degilevich.dream.shared.foundation.decompose.compose.lifecycle

import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun SubscribeToLifecycleDisposalEffect(
    viewLifecycleCallbacks: ViewLifecycleCallbacks
) {
    DisposableEffect(viewLifecycleCallbacks) {
        viewLifecycleCallbacks.onViewCreated()
        onDispose {
            viewLifecycleCallbacks.onViewDestroyed()
        }
    }
}