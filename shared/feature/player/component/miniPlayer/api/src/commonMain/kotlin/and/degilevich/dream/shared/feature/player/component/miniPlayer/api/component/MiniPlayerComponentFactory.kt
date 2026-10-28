package and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component

import com.arkivanov.decompose.ComponentContext

interface MiniPlayerComponentFactory {

    fun create(componentContext: ComponentContext): MiniPlayerComponent
}
