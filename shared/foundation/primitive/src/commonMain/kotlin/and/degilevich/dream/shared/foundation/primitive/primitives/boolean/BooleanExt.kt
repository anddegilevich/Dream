package and.degilevich.dream.shared.foundation.primitive.primitives.boolean

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}