package and.degilevich.dream.shared.feature.player.domain.impl.manager

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.seconds

internal class PlayerManagerImpl(
    private val playerRepository: PlayerRepository
) : PlayerManager {

    private val playerStateMutable = MutableStateFlow<PlayerStateData>(PlayerStateData.Idle)

    private val pollingLock = Mutex()

    override val playerState: Flow<PlayerStateData> = flow {
        coroutineScope {
            launch { pollingLock.withLock { pollWhileCollected() } }
            emitAll(playerStateMutable)
        }
    }

    override suspend fun skipToNext(): Result<Unit> {
        return playerRepository.skipToNext().onSuccess { fetchPlayerState() }
    }

    override suspend fun skipToPrevious(): Result<Unit> {
        return playerRepository.skipToPrevious().onSuccess { fetchPlayerState() }
    }

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> {
        return playerRepository.setShuffle(params = params).onSuccess { fetchPlayerState() }
    }

    private suspend fun fetchPlayerState() {
        playerRepository.getPlaybackState().onSuccess { result ->
            playerStateMutable.value = result.toPlayerState()
        }
    }

    private suspend fun pollWhileCollected() = coroutineScope {
        launch { pollPlayerState() }
        launch { advanceProgressWhilePlaying() }
    }

    private suspend fun pollPlayerState() {
        while (true) {
            fetchPlayerState()
            delay(POLLING_INTERVAL)
        }
    }

    private suspend fun advanceProgressWhilePlaying() {
        while (true) {
            delay(PROGRESS_TICK_INTERVAL)
            playerStateMutable.update { state ->
                state.withProgressAdvancedBy(PROGRESS_TICK_INTERVAL.inWholeMilliseconds.toInt())
            }
        }
    }

    private fun PlayerStateData.withProgressAdvancedBy(progressMs: Int): PlayerStateData {
        if (this !is PlayerStateData.Active || !playbackState.isPlaying) return this
        val progressedMs = (playbackState.progressMs + progressMs).coerceAtMost(playbackState.track.durationMs)
        return copy(
            playbackState = playbackState.copy(progressMs = progressedMs)
        )
    }

    private fun GetPlaybackStateResult.toPlayerState(): PlayerStateData = when (this) {
        is GetPlaybackStateResult.None -> PlayerStateData.Idle
        is GetPlaybackStateResult.Value -> PlayerStateData.Active(playbackState = playbackState)
    }

    private companion object {
        val POLLING_INTERVAL = 3.seconds
        val PROGRESS_TICK_INTERVAL = 1.seconds
    }
}
