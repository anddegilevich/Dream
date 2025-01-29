package and.degilevich.dream.shared.foundation.decompose.lifecycle.ext

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle

inline fun ExtendedLifecycle.doOnViewCreated(
    isOneTime: Boolean = false,
    crossinline block: () -> Unit
) {
    subscribe(
        object : ExtendedLifecycle.Callbacks {
            override fun onViewCreated() {
                if (isOneTime) {
                    unsubscribe(this)
                }
                block()
            }
        }
    )
}

inline fun ExtendedLifecycle.doOnViewDestroyed(
    isOneTime: Boolean = false,
    crossinline block: () -> Unit
) {
    subscribe(
        object : ExtendedLifecycle.Callbacks {
            override fun onViewDestroyed() {
                if (isOneTime) {
                    unsubscribe(this)
                }
                block()
            }
        }
    )
}