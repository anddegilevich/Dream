package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerUIState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import org.koin.core.component.KoinComponent

internal class PlayerUIStateMapper : Mapper<PlayerState, PlayerUIState>, KoinComponent {

    override fun map(item: PlayerState): PlayerUIState = TODO()
}
