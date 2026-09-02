package and.degilevich.dream.shared.feature.common.component.splash.api.component

import com.arkivanov.decompose.ComponentContext

interface SplashComponentFactory {

    fun create(componentContext: ComponentContext): SplashComponent
}
