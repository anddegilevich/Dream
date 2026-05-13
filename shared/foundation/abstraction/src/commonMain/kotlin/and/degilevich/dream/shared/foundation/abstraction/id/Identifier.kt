package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState

interface Identifier : EmptyState {
    val value: String

    override fun isEmpty() = value.isEmpty()
}

fun identifier(value: String): AnyIdentifier {
    return AnyIdentifier(value = value)
}

fun emptyIdentifier(): AnyIdentifier {
    return AnyIdentifier.empty()
}