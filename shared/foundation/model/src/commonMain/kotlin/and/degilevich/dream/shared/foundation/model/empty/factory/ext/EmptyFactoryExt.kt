package and.degilevich.dream.shared.foundation.model.empty.factory.ext

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory

fun <T> T?.orEmpty(factory: EmptyFactory<T>): T {
    return this ?: factory.empty()
}