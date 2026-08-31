package and.degilevich.dream.shared.feature.auth.component.login.impl.di

import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponent
import and.degilevich.dream.shared.feature.auth.component.login.impl.component.LoginComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun loginComponentModule() = module {
    factory<LoginComponent> { (componentContext: ComponentContext) ->
        LoginComponentImpl(componentContext = componentContext)
    }
}
