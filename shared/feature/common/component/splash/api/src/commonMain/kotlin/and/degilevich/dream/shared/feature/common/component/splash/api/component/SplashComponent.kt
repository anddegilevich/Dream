package and.degilevich.dream.shared.feature.common.component.splash.api.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashUIState
import and.degilevich.dream.shared.feature.common.component.splash.api.design.SplashScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface SplashComponent : RenderMVIComponent<SplashUIState, SplashIntent, SplashSideEffect> {

    @Composable
    override fun Render() {
        SplashScreen()
    }
}