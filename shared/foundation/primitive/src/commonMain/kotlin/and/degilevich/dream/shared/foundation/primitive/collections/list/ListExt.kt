package and.degilevich.dream.shared.foundation.primitive.collections.list

fun <T> List<T>.orNullIfEmpty(): List<T>? {
    return ifEmpty { null }
}

inline fun <T> List<T>.indexOfFirstOrNull(predicate: (T) -> Boolean): Int? {
    val index = indexOfFirst(predicate)
    return if (index == -1) null else index
}