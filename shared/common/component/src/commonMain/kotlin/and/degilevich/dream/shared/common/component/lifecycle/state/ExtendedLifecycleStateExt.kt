package and.degilevich.dream.shared.common.component.lifecycle.state

inline fun ExtendedLifecycleState.doOnCreate(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_CREATE) block()
}

inline fun ExtendedLifecycleState.doOnStart(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_START) block()
}

inline fun ExtendedLifecycleState.doOnResume(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_RESUME) block()
}

inline fun ExtendedLifecycleState.doOnPause(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_PAUSE) block()
}

inline fun ExtendedLifecycleState.doOnViewCreated(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_VIEW_CREATED) block()
}

inline fun ExtendedLifecycleState.doOnViewDestroyed(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_VIEW_DESTROYED) block()
}

inline fun ExtendedLifecycleState.doOnStop(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_STOP) block()
}

inline fun ExtendedLifecycleState.doOnDestroy(crossinline block: () -> Unit) {
    if (this == ExtendedLifecycleState.ON_DESTROY) block()
}