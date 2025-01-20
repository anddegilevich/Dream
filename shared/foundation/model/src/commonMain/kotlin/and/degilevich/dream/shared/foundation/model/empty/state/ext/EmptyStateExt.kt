package and.degilevich.dream.shared.foundation.model.empty.state.ext

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

fun <T : EmptyState> T?.orEmpty(factory: EmptyFactory<T>): T {
    return this ?: factory.empty()
}