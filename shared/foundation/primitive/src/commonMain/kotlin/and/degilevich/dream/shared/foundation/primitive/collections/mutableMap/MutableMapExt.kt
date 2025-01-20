package and.degilevich.dream.shared.foundation.primitive.collections.mutableMap

fun <T>MutableMap<T, Boolean>.toggle(key: T): MutableMap<T, Boolean> {
    val currentValue = get(key) ?: return this
    set(
        key = key,
        value = !currentValue
    )
    return this
}