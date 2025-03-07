package and.degilevich.dream.shared.foundation.abstraction.empty.state

interface EmptyState {
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean = !isEmpty()
}