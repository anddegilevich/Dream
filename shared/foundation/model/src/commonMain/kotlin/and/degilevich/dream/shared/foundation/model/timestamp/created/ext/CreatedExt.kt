package and.degilevich.dream.shared.foundation.model.timestamp.created.ext

import and.degilevich.dream.shared.foundation.model.timestamp.created.Created

fun <T : Created> Iterable<T>.sortedByCreated(): List<T> {
    return this.sortedBy { item -> item.created }
}

fun <T : Created> Iterable<T>.sortedByCreatedDescending(): List<T> {
    return this.sortedByDescending { item -> item.created }
}