package and.degilevich.dream.shared.feature.common.component.dashboard.api.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardIntent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSideEffect
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface DashboardComponent : MVIComponent<DashboardUIState, DashboardIntent, DashboardSideEffect>