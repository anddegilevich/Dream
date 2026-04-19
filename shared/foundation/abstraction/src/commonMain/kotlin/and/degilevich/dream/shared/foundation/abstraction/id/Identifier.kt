package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState

interface Identifier : EmptyState {
    val value: String

    override fun isEmpty() = value.isEmpty()
}

fun identifier(value: String): Identifier {
    return IdentifierImpl(value = value)
}

fun emptyIdentifier(): Identifier {
    return IdentifierImpl.empty()
}