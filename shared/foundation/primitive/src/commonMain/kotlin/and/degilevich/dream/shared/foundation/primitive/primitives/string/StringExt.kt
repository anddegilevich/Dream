package and.degilevich.dream.shared.foundation.primitive.primitives.string

inline fun String?.ifNullOrEmpty(default: () -> String): String {
    return this?.ifEmpty(default) ?: default()
}

fun String?.orDash(): String {
    return this.ifNullOrEmpty { "-" }
}
