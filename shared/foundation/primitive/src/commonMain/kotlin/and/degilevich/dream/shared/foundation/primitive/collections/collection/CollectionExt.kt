package and.degilevich.dream.shared.foundation.primitive.collections.collection

fun <T> Collection<T>.isOneItem(): Boolean {
    return size == 1
}