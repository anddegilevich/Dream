package and.degilevich.dream.shared.feature.player.domain.api.manager

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import kotlinx.coroutines.flow.Flow

interface PlayerManager {

    val playerState: Flow<PlayerStateData>

    suspend fun skipToNext(): Result<Unit>

    suspend fun skipToPrevious(): Result<Unit>

    suspend fun setShuffle(params: SetShuffleParams): Result<Unit>
}
