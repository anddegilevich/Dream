package and.degilevich.dream.shared.feature.common.component.drawer.api.component

import com.arkivanov.decompose.ComponentContext

interface DrawerComponentFactory {

    fun create(componentContext: ComponentContext): DrawerComponent
}
