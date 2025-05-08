package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardIntent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSideEffect
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import and.degilevich.dream.shared.template.component.MVIComponentTemplate
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow

class DashboardComponentImpl(
    componentContext: ComponentContext
) : MVIComponentTemplate<DashboardUIState, DashboardIntent, DashboardSideEffect>(
    componentContext = componentContext
),
    DashboardComponent {
    override val state: StateFlow<DashboardUIState> = MutableStateFlow(DashboardUIState())
    override val sideEffect: Flow<DashboardSideEffect> = emptyFlow()

    override fun handleIntent(intent: DashboardIntent) {
        // FIXME: Implement later
    }
}