package and.degilevich.dream.shared.feature.common.home.api.component

import com.arkivanov.decompose.ComponentContext

interface HomeComponentFactory {

    fun create(componentContext: ComponentContext): HomeComponent
}
