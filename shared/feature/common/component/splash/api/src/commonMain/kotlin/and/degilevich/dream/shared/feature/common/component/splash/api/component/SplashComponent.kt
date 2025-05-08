package and.degilevich.dream.shared.feature.common.component.splash.api.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface SplashComponent : MVIComponent<SplashUIState, SplashIntent, SplashSideEffect>