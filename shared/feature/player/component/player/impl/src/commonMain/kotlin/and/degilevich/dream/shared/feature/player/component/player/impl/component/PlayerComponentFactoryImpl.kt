package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.api.component.PlayerComponent
import and.degilevich.dream.shared.feature.player.component.player.api.component.PlayerComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class PlayerComponentFactoryImpl : PlayerComponentFactory {

    override fun create(componentContext: ComponentContext): PlayerComponent = PlayerComponentImpl(
        componentContext = componentContext
    )
}
