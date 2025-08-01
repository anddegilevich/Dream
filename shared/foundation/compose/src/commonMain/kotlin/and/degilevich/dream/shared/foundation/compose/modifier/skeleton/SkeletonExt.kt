package and.degilevich.dream.shared.foundation.compose.modifier.skeleton

fun <T> Skeleton<T>.getOrNull(): T? {
    return when (this) {
        is Skeleton.Value -> this.value
        is Skeleton.Loading -> null
    }
}

fun <T> Skeleton<T>.getOrDefault(defaultValue: T): T {
    return when (this) {
        is Skeleton.Value -> this.value
        is Skeleton.Loading -> defaultValue
    }
}

inline fun <T, R> Skeleton<T>.fold(
    onValue: (value: T) -> R,
    onLoading: () -> R
): R {
    return when (this) {
        is Skeleton.Value -> onValue(this.value)
        is Skeleton.Loading -> onLoading()
    }
}

inline fun <T> Skeleton<T>.onValue(action: (value: T) -> Unit): Skeleton<T> {
    if (this is Skeleton.Value) {
        action(value)
    }
    return this
}

inline fun <T> Skeleton<T>.onLoading(action: () -> Unit): Skeleton<T> {
    if (this is Skeleton.Loading) {
        action()
    }
    return this
}