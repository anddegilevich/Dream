package and.degilevich.dream.shared.foundation.model.id

import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

abstract class IdentifiedAbs : EmptyState, Identified {
    override fun isEmpty(): Boolean {
        return id.isEmpty()
    }
}