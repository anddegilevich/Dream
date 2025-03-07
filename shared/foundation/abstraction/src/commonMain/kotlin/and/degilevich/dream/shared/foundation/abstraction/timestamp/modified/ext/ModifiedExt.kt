package and.degilevich.dream.shared.foundation.abstraction.timestamp.modified.ext

import and.degilevich.dream.shared.foundation.abstraction.timestamp.modified.Modified

fun <T : Modified> Iterable<T>.sortedByModified(): List<T> {
    return this.sortedBy { item -> item.modified }
}

fun <T : Modified> Iterable<T>.sortedByModifiedDescending(): List<T> {
    return this.sortedByDescending { item -> item.modified }
}