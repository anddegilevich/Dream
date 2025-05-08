package and.degilevich.dream.shared.feature.common.component.splash.impl.store

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import com.arkivanov.mvikotlin.core.store.Store

internal interface SplashStore : Store<SplashIntent, SplashState, SplashSideEffect>