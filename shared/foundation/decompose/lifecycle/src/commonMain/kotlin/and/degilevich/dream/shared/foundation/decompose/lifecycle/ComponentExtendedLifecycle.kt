package and.degilevich.dream.shared.foundation.decompose.lifecycle

import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks
import com.arkivanov.essenty.lifecycle.Lifecycle

class ComponentExtendedLifecycle(
    private val componentLifecycle: Lifecycle
) : ExtendedLifecycle, Lifecycle by componentLifecycle {

    private val onViewCreatedSubscribers = mutableListOf<ViewLifecycleCallbacks>()

    override fun subscribe(
        callbacks: ExtendedLifecycle.Callbacks
    ) {
        onViewCreatedSubscribers.add(callbacks)
        componentLifecycle.subscribe(callbacks)
    }

    override fun subscribe(
        onCreate: (() -> Unit)?,
        onStart: (() -> Unit)?,
        onResume: (() -> Unit)?,
        onViewCreated: (() -> Unit)?,
        onPause: (() -> Unit)?,
        onStop: (() -> Unit)?,
        onDestroy: (() -> Unit)?,
        onViewDestroyed: (() -> Unit)?
    ) {
        val callbacks = object : ExtendedLifecycle.Callbacks {
            override fun onCreate() {
                onCreate?.invoke()
            }

            override fun onStart() {
                onStart?.invoke()
            }

            override fun onResume() {
                onResume?.invoke()
            }

            override fun onViewCreated() {
                onViewCreated?.invoke()
            }

            override fun onViewDestroyed() {
                onViewDestroyed?.invoke()
            }

            override fun onPause() {
                onPause?.invoke()
            }

            override fun onStop() {
                onStop?.invoke()
            }

            override fun onDestroy() {
                onDestroy?.invoke()
            }
        }
        subscribe(callbacks)
    }

    override fun unsubscribe(callbacks: ExtendedLifecycle.Callbacks) {
        onViewCreatedSubscribers.remove(callbacks)
        componentLifecycle.unsubscribe(callbacks)
    }

    override fun onViewCreated() {
        onViewCreatedSubscribers.forEach { callback ->
            callback.onViewCreated()
        }
    }

    override fun onViewDestroyed() {
        onViewCreatedSubscribers.forEach { callback ->
            callback.onViewDestroyed()
        }
    }
}