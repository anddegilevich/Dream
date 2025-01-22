package and.degilevich.dream.shared.foundation.decompose.navigator.result

import and.degilevich.dream.shared.foundation.decompose.navigator.result.collector.NavigationResultCollector
import com.arkivanov.essenty.lifecycle.Lifecycle

interface NavigationResultManager {
    fun collectNavigationResults(
        lifecycle: Lifecycle,
        block: NavigationResultCollector.() -> Unit
    )

    fun sendNavigationResult(
        key: String,
        result: Any
    )
}