package and.degilevich.dream.shared.feature.common.component.navbar.impl.di

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponentListener
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun navbarComponentModule() = module {
    factory<NavbarComponent> { (componentContext: ComponentContext, listener: NavbarComponentListener) ->
        NavbarComponentImpl(
            componentContext = componentContext,
            listener = listener
        )
    }
}
