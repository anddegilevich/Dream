package and.degilevich.dream.shared.feature.auth.component.login.impl.component

import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponent
import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class LoginComponentFactoryImpl : LoginComponentFactory {

    override fun create(componentContext: ComponentContext): LoginComponent = LoginComponentImpl(
        componentContext = componentContext
    )
}
