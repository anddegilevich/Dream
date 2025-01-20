package and.degilevich.dream.shared.foundation.primitive.primitives.string

fun String.orNullIfEmpty(): String? {
    return this.ifEmpty { null }
}

inline fun String?.ifNullOrEmpty(default: () -> String): String {
    return this?.ifEmpty(default) ?: default()
}

fun String?.orDash(): String {
    return this.ifNullOrEmpty { "-" }
}