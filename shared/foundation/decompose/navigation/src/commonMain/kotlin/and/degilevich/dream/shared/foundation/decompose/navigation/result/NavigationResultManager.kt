package and.degilevich.dream.shared.foundation.decompose.navigation.result

import com.arkivanov.essenty.lifecycle.Lifecycle
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

interface NavigationResultManager {

    val state: NavigationResultManagerState

    fun <T> sendResult(
        navKey: String,
        serializer: SerializationStrategy<T>,
        result: T
    )

    fun <T> subscribeToResult(
        navKey: String,
        lifecycle: Lifecycle,
        deserializer: DeserializationStrategy<T>,
        onResult: (T) -> Unit
    )
}

fun NavigationResultManager(initialState: NavigationResultManagerState): NavigationResultManager {
    return NavigationResultManagerImpl(initialState)
}