package and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory

fun <T> T?.orEmpty(factory: EmptyFactory<T>): T {
    return this ?: factory.empty()
}