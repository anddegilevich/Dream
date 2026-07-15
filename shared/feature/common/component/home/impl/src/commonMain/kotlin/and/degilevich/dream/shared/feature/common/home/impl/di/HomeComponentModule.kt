package and.degilevich.dream.shared.feature.common.home.impl.di

import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.HomeComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun homeComponentModule() = module {
    factory<HomeComponent> { (componentContext: ComponentContext) ->
        HomeComponentImpl(componentContext = componentContext)
    }
}
