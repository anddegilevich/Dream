package and.degilevich.dream.shared.foundation.primitive.collections.list

inline fun <T> List<T>.indexOfFirstOrNull(predicate: (T) -> Boolean): Int? {
    val index = indexOfFirst(predicate)
    return if (index == -1) null else index
}

fun <T> List<List<T>>.interleave(): List<T> {
    val maxSize = maxOfOrNull { list -> list.size } ?: return emptyList()
    return (0 until maxSize).flatMap { index ->
        mapNotNull { list ->
            list.getOrNull(index)
        }
    }
}
