package and.degilevich.dream.shared.feature.player.domain.test.manager

import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import kotlinx.coroutines.flow.Flow

class FakePlayerManager(
    private val onPlayerState: () -> Flow<PlayerStateData> = { fakeImplementationError() },
    private val onSkipToNext: suspend () -> Result<Unit> = { fakeImplementationError() },
    private val onSkipToPrevious: suspend () -> Result<Unit> = { fakeImplementationError() },
    private val onSetShuffle: suspend (SetShuffleParams) -> Result<Unit> = { fakeImplementationError() }
) : PlayerManager {

    override val playerState: Flow<PlayerStateData>
        get() = onPlayerState()

    override suspend fun skipToNext(): Result<Unit> = onSkipToNext()

    override suspend fun skipToPrevious(): Result<Unit> = onSkipToPrevious()

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> = onSetShuffle(params)
}
