package and.degilevich.dream.shared.foundation.decompose.navigation.result

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable

@Serializable
data class NavigationResultManagerState(
    val navKeysToResultsMap: Map<String, String>
) {
    companion object : EmptyFactory<NavigationResultManagerState> {
        override fun empty(): NavigationResultManagerState {
            return NavigationResultManagerState(
                navKeysToResultsMap = emptyMap()
            )
        }
    }
}