package and.degilevich.dream.shared.navigation.impl

import and.degilevich.dream.shared.navigation.api.component.AppNavigationComponent
import and.degilevich.dream.shared.navigation.api.component.AppNavigationComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class AppNavigationComponentFactoryImpl : AppNavigationComponentFactory {

    override fun create(componentContext: ComponentContext): AppNavigationComponent = AppNavigationComponentImpl(
        componentContext = componentContext
    )
}
