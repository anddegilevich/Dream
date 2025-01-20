package and.degilevich.dream.shared.foundation.primitive.collections.map

fun <K> Map<K, Boolean>.isAnySelected(): Boolean {
    return values.any { it }
}

fun <K> Map<K, Boolean>.firstSelectedKeyOrNull(): K? {
    return entries.find { entry ->
        entry.value
    }?.key
}

fun <K> Map<K, Boolean>.selectedKeys(): List<K> {
    return entries
        .asSequence()
        .filter { it.value }
        .map { it.key }
        .toList()
}