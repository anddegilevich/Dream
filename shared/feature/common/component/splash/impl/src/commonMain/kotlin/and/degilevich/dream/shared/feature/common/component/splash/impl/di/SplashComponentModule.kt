package and.degilevich.dream.shared.feature.common.component.splash.impl.di

import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.SplashComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun splashComponentModule() = module {
    factory<SplashComponent> { (componentContext: ComponentContext) ->
        SplashComponentImpl(componentContext = componentContext)
    }
}
