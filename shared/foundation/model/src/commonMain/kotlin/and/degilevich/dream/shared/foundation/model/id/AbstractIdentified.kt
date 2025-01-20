package and.degilevich.dream.shared.foundation.model.id

import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

abstract class AbstractIdentified : EmptyState, Identified {
    override fun isEmpty(): Boolean {
        return id.isEmpty()
    }
}