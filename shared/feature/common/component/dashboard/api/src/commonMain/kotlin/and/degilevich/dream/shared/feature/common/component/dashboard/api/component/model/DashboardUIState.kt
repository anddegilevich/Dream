package and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
class DashboardUIState {
    companion object : EmptyFactory<DashboardUIState> {
        override fun empty(): DashboardUIState {
            return DashboardUIState()
        }
    }
}