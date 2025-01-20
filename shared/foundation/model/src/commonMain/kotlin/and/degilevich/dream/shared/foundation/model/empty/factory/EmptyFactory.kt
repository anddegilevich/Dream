package and.degilevich.dream.shared.foundation.model.empty.factory

import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

interface EmptyFactory<T : EmptyState> {
    fun empty(): T
}