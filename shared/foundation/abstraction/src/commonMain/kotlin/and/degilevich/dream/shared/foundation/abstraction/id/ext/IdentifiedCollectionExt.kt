package and.degilevich.dream.shared.foundation.abstraction.id.ext

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orNullIfNegative

fun <T : Identified> Iterable<T>.distinctById(): List<T> {
    return this.distinctBy { item -> item.id }
}

fun <T : Identified> Iterable<T>.getById(id: Identifier): T? {
    return this.firstOrNull { item -> item.id == id }
}

fun <T : Identified> Iterable<T>.mapItem(
    id: Identifier,
    transform: (T) -> T
): List<T> {
    return map { item ->
        if (item.id == id) {
            transform(item)
        } else {
            item
        }
    }
}

fun <T : Identified> Iterable<T>.ids(): List<Identifier> {
    return this.map { item -> item.id }
}

fun <T : Identified> Iterable<T>.containsId(id: Identifier): Boolean {
    return this.any { item -> item.id == id }
}

fun <T : Identified> Iterable<T>.indexOfItemWithId(id: Identifier): Int? {
    return this.indexOfFirst { item -> item.id == id }.orNullIfNegative()
}