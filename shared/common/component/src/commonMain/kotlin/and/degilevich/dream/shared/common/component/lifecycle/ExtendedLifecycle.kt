package and.degilevich.dream.shared.common.component.lifecycle

import and.degilevich.dream.shared.common.component.lifecycle.view.ViewLifecycleCallbacks
import com.arkivanov.essenty.lifecycle.Lifecycle

interface ExtendedLifecycle : ViewLifecycleCallbacks, Lifecycle {
    fun subscribe(callbacks: Callbacks)
    fun subscribe(
        onCreate: (() -> Unit)? = null,
        onStart: (() -> Unit)? = null,
        onResume: (() -> Unit)? = null,
        onViewCreated: (() -> Unit)? = null,
        onPause: (() -> Unit)? = null,
        onStop: (() -> Unit)? = null,
        onDestroy: (() -> Unit)? = null,
        onViewDestroyed: (() -> Unit)? = null
    )
    fun unsubscribe(callbacks: Callbacks)

    interface Callbacks : Lifecycle.Callbacks, ViewLifecycleCallbacks
}