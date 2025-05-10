package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class DashboardUIState(
    val isLoading: Boolean
) {
    companion object : EmptyFactory<DashboardUIState> {
        override fun empty(): DashboardUIState {
            return DashboardUIState(
                isLoading = false
            )
        }
    }
}