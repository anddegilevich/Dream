package and.degilevich.dream.shared.feature.common.component.navbar.api.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import androidx.compose.runtime.Stable

@Stable
interface NavbarComponent : MVIComponent<NavbarUIState, NavbarIntent, NavbarSideEffect>