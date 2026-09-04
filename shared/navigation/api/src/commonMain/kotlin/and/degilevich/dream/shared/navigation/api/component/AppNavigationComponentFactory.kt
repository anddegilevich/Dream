package and.degilevich.dream.shared.navigation.api.component

import com.arkivanov.decompose.ComponentContext

interface AppNavigationComponentFactory {

    fun create(componentContext: ComponentContext): AppNavigationComponent
}
