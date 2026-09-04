package and.degilevich.dream.shared.feature.common.home.impl.component

import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class HomeComponentFactoryImpl : HomeComponentFactory {

    override fun create(componentContext: ComponentContext): HomeComponent = HomeComponentImpl(
        componentContext = componentContext
    )
}
