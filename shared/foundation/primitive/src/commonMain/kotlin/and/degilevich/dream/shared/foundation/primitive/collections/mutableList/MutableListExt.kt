package and.degilevich.dream.shared.foundation.primitive.collections.mutableList

fun <T> MutableList<T>.addOrReplaceFirst(
    item: T,
    areEquivalent: (old: T, new: T) -> Boolean = { old, new ->
        old == new
    }
) {
    val indexOfSameItem = indexOfFirst { listItem ->
        areEquivalent(listItem, item)
    }
    if (indexOfSameItem == -1) {
        add(item)
    } else {
        set(indexOfSameItem, item)
    }
}

fun <T> MutableList<T>.removeFirstIf(predicate: (T) -> Boolean): Boolean {
    val index = indexOfFirst(predicate)
    return if (index != -1) {
        removeAt(index)
        true
    } else {
        false
    }
}