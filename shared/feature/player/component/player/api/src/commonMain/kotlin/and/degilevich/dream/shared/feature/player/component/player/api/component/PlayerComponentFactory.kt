package and.degilevich.dream.shared.feature.player.component.player.api.component

import com.arkivanov.decompose.ComponentContext

interface PlayerComponentFactory {

    fun create(componentContext: ComponentContext): PlayerComponent
}
