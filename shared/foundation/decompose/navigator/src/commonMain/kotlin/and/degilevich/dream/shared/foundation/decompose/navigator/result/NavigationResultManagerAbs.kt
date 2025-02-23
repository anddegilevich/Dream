package and.degilevich.dream.shared.foundation.decompose.navigator.result

import and.degilevich.dream.shared.foundation.decompose.navigator.result.collector.NavigationResultCollector
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnStop

abstract class NavigationResultManagerAbs : NavigationResultManager {

    private val navigationResults: HashMap<String, Any> = hashMapOf()
    private val resultCallbacks: HashMap<String, (Any) -> Unit> = hashMapOf()

    override fun collectNavigationResults(
        lifecycle: Lifecycle,
        block: NavigationResultCollector.() -> Unit
    ) {
        NavigationResultCollector()
            .apply(block)
            .collectorItems
            .forEach { item ->
                collectNavigationResult(
                    lifecycle = lifecycle,
                    key = item.key,
                    resultCallback = item.resultCallback
                )
            }
    }

    override fun sendNavigationResult(key: String, result: Any) {
        if (key.isEmpty()) return
        val resultCallback = resultCallbacks[key]
        if (resultCallback != null) {
            resultCallback(result)
        } else {
            navigationResults[key] = result
        }
    }

    protected fun collectNavigationResult(
        lifecycle: Lifecycle,
        key: String,
        resultCallback: (Any) -> Unit
    ) {
        val result = navigationResults.remove(key)
        if (result != null) {
            resultCallback(result)
        } else {
            resultCallbacks[key] = resultCallback
            lifecycle.doOnStop(
                isOneTime = true
            ) {
                resultCallbacks.remove(key)
            }
        }
    }
}