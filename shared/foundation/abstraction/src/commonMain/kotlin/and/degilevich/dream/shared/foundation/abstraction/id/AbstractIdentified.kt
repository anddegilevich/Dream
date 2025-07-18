package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState

abstract class AbstractIdentified : EmptyState, Identified {
    override fun isEmpty(): Boolean {
        return id.isEmpty()
    }
}