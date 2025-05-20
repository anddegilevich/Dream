package and.degilevich.dream.shared.foundation.decompose.navigation.ext

import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import com.arkivanov.essenty.lifecycle.Lifecycle
import kotlinx.serialization.serializer

inline fun <reified T> NavigationResultManager.sendResult(
    navKey: String,
    result: T
) {
    runCatching {
        JsonSerialFormat.serializersModule.serializer<T>()
    }.onSuccess { serializer ->
        sendResult(
            navKey = navKey,
            serializer = serializer,
            result = result
        )
    }
}

inline fun <reified T> NavigationResultManager.subscribeToResult(
    navKey: String,
    lifecycle: Lifecycle,
    noinline onResult: (T) -> Unit
) {
    runCatching {
        JsonSerialFormat.serializersModule.serializer<T>()
    }.onSuccess { serializer ->
        subscribeToResult(
            navKey = navKey,
            lifecycle = lifecycle,
            deserializer = serializer,
            onResult = onResult
        )
    }
}