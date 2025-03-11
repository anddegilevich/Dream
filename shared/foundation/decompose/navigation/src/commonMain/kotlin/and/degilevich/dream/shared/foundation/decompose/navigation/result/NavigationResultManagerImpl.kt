package and.degilevich.dream.shared.foundation.decompose.navigation.result

import and.degilevich.dream.shared.foundation.serialization.decodeFromJson
import and.degilevich.dream.shared.foundation.serialization.encodeToJsonOrNull
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnStop
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy

internal class NavigationResultManagerImpl(
    initialState: NavigationResultManagerState = NavigationResultManagerState.empty()
) : NavigationResultManager {

    private val navKeysToResultsMap: HashMap<String, String> = hashMapOf<String, String>().apply {
        putAll(initialState.navKeysToResultsMap)
    }
    private val navKeysToSubscribersMap: HashMap<String, (String) -> Unit> = hashMapOf()

    override val state: NavigationResultManagerState
        get() = NavigationResultManagerState(
            navKeysToResultsMap = navKeysToResultsMap.toMap()
        )

    override fun <T> sendResult(
        navKey: String,
        serializer: SerializationStrategy<T>,
        result: T
    ) {
        val serializedResult = result.encodeToJsonOrNull(serializer = serializer) ?: return
        sendSerializedResult(
            navKey = navKey,
            result = serializedResult
        )
    }

    override fun <T> subscribeToResult(
        navKey: String,
        lifecycle: Lifecycle,
        deserializer: DeserializationStrategy<T>,
        onResult: (T) -> Unit
    ) {
        subscribeToSerializedResult(
            navKey = navKey,
            lifecycle = lifecycle,
            resultCallback = { serializerResult ->
                serializerResult.decodeFromJson(deserializer)
                    .onSuccess { result ->
                        onResult(result)
                    }
            }
        )
    }

    private fun sendSerializedResult(
        navKey: String,
        result: String
    ) {
        val resultCallback = navKeysToSubscribersMap[navKey]
        if (resultCallback != null) {
            resultCallback(result)
        } else {
            navKeysToResultsMap[navKey] = result
        }
    }

    private fun subscribeToSerializedResult(
        navKey: String,
        resultCallback: (String) -> Unit,
        lifecycle: Lifecycle
    ) {
        val result = navKeysToResultsMap.remove(navKey)
        if (result != null) {
            resultCallback(result)
        } else {
            navKeysToSubscribersMap[navKey] = resultCallback
            lifecycle.doOnStop(
                isOneTime = true
            ) {
                navKeysToSubscribersMap.remove(navKey)
            }
        }
    }
}