package and.degilevich.dream.shared.foundation.primitive.collections.persistentList

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

inline fun <T> buildPersistentList(block: MutableList<T>.() -> Unit): PersistentList<T> {
    return persistentListOf<T>().builder().apply(block).build()
}