package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class DrawerComponentFactoryImpl : DrawerComponentFactory {

    override fun create(componentContext: ComponentContext): DrawerComponent = DrawerComponentImpl(
        componentContext = componentContext
    )
}
