package and.degilevich.dream.shared.feature.common.component.navbar.api.component

import com.arkivanov.decompose.ComponentContext

interface NavbarComponentFactory {

    fun create(componentContext: ComponentContext): NavbarComponent
}
