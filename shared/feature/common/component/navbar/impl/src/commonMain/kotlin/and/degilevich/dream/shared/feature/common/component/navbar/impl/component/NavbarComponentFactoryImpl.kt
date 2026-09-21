package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class NavbarComponentFactoryImpl : NavbarComponentFactory {

    override fun create(componentContext: ComponentContext): NavbarComponent = NavbarComponentImpl(
        componentContext = componentContext
    )
}
