package and.degilevich.dream.shared.foundation.primitive.reflection

import kotlin.reflect.KClass

fun <T : Any> KClass<T>.className(): String {
    return this.simpleName.toString()
}

inline fun <reified T : Any> T.className(): String {
    return this::class.className()
}