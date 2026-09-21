package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class SplashComponentFactoryImpl : SplashComponentFactory {

    override fun create(componentContext: ComponentContext): SplashComponent = SplashComponentImpl(
        componentContext = componentContext
    )
}
