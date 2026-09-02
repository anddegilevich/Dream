package and.degilevich.dream.shared.feature.auth.component.login.api.component

import com.arkivanov.decompose.ComponentContext

interface LoginComponentFactory {

    fun create(componentContext: ComponentContext): LoginComponent
}
