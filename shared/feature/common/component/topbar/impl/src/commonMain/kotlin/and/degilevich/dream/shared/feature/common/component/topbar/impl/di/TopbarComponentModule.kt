package and.degilevich.dream.shared.feature.common.component.topbar.impl.di

import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.TopbarComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun topbarComponentModule() = module {
    factory<TopbarComponent> { (componentContext: ComponentContext) ->
        TopbarComponentImpl(componentContext = componentContext)
    }
}
