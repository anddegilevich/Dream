package and.degilevich.dream.shared.foundation.primitive.collections.list

fun <T> List<T>.orNullIfEmpty(): List<T>? {
    return ifEmpty { null }
}

inline fun <T> List<T>.indexOfFirstOrNull(predicate: (T) -> Boolean): Int? {
    val index = indexOfFirst(predicate)
    return if (index == -1) null else index
}

fun <T> List<T>.takeUnlessEmpty(): List<T>? {
    return this.takeUnless { it.isEmpty() }
}

fun <T> List<List<T>>.interleave(): List<T> {
    val maxSize = maxOfOrNull { list -> list.size } ?: return emptyList()
    return (0 until maxSize).flatMap { index ->
        mapNotNull { list ->
            list.getOrNull(index)
        }
    }
}
