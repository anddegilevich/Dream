package and.degilevich.dream.shared.foundation.compose.modifier.skeleton

import androidx.compose.runtime.Stable

@Stable
sealed interface Skeleton<out T> {

    @Stable
    data class Value<out T>(val value: T) : Skeleton<T>

    @Stable
    data object Loading : Skeleton<Nothing>

    companion object {
        inline fun <T> from(
            isLoading: Boolean,
            crossinline block: () -> T
        ): Skeleton<T> {
            return if (isLoading) Loading else Value(block())
        }
    }
}