package and.degilevich.dream.shared.feature.common.component.topbar.api.component

import com.arkivanov.decompose.ComponentContext

interface TopbarComponentFactory {

    fun create(componentContext: ComponentContext): TopbarComponent
}
