package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component

import and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component.MiniPlayerComponent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component.MiniPlayerComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class MiniPlayerComponentFactoryImpl : MiniPlayerComponentFactory {

    override fun create(componentContext: ComponentContext): MiniPlayerComponent = MiniPlayerComponentImpl(
        componentContext = componentContext
    )
}
