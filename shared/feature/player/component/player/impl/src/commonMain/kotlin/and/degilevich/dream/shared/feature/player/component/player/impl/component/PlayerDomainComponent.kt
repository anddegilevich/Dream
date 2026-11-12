package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerIntent
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerSideEffect
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext

internal class PlayerDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<PlayerState, PlayerIntent, PlayerSideEffect>(
    componentContext = componentContext,
    stateConservator = PlayerStateConservator()
) {

    override fun handleIntent(intent: PlayerIntent): Unit = TODO()
}
