package and.degilevich.dream.shared.feature.common.component.splash.impl.component.model

sealed interface SplashIntent {
    data object OnIntroFinished : SplashIntent
}
