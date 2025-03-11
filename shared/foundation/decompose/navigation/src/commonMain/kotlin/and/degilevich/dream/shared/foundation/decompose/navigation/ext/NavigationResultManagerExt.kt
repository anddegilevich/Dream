package and.degilevich.dream.shared.foundation.decompose.navigation.ext

import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import com.arkivanov.essenty.lifecycle.Lifecycle
import kotlinx.serialization.serializer

inline fun <reified T> NavigationResultManager.sendResult(
    navKey: String,
    result: T
) {
    sendResult(
        navKey = navKey,
        serializer = JsonSerialFormat.serializersModule.serializer(),
        result = result
    )
}

inline fun <reified T> NavigationResultManager.subscribeToResult(
    navKey: String,
    lifecycle: Lifecycle,
    noinline onResult: (T) -> Unit
) {
    subscribeToResult(
        navKey = navKey,
        lifecycle = lifecycle,
        deserializer = JsonSerialFormat.serializersModule.serializer(),
        onResult = onResult
    )
}