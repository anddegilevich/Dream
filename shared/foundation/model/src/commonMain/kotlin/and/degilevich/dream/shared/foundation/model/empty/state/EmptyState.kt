package and.degilevich.dream.shared.foundation.model.empty.state

interface EmptyState {
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean = !isEmpty()
}