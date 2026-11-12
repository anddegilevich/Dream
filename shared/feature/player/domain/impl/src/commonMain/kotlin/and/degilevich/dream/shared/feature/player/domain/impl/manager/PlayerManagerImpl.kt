package and.degilevich.dream.shared.feature.player.domain.impl.manager

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.getPlaybackState.GetPlaybackStateResult
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

internal class PlayerManagerImpl(
    private val playerRepository: PlayerRepository
) : PlayerManager {

    private val playerStateMutable = MutableStateFlow<PlayerStateData>(PlayerStateData.Idle)

    private val progressTickerEnabled = MutableSharedFlow<Boolean>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val pollingLock = Mutex()

    override val playerState: Flow<PlayerStateData> = flow {
        coroutineScope {
            launch { pollingLock.withLock { pollWhileCollected() } }
            emitAll(playerStateMutable)
        }
    }

    override suspend fun skipToNext(): Result<Unit> {
        return playerRepository.skipToNext().onSuccess {
            stopProgressTicker()
            updatePlaybackState { copy(progressMs = 0) }
            refreshPlayerState()
        }
    }

    override suspend fun skipToPrevious(): Result<Unit> {
        return playerRepository.skipToPrevious().onSuccess {
            stopProgressTicker()
            updatePlaybackState { copy(progressMs = 0) }
            refreshPlayerState()
        }
    }

    override suspend fun setShuffle(params: SetShuffleParams): Result<Unit> {
        return playerRepository.setShuffle(params = params).onSuccess {
            updatePlaybackState { copy(isShuffling = params.isEnabled) }
            refreshPlayerState()
        }
    }

    override suspend fun pause(): Result<Unit> {
        return playerRepository.pause().onSuccess {
            stopProgressTicker()
            updatePlaybackState { copy(isPlaying = false) }
            refreshPlayerState()
        }
    }

    override suspend fun resume(): Result<Unit> {
        return playerRepository.resume().onSuccess {
            updatePlaybackState { copy(isPlaying = true) }
            refreshPlayerState()
        }
    }

    private suspend fun refreshPlayerState() {
        delay(REFRESH_DELAY)
        fetchPlayerState()
    }

    private suspend fun fetchPlayerState() {
        playerRepository.getPlaybackState().onSuccess { result ->
            val playerState = result.toPlayerState()
            playerStateMutable.value = playerState
            progressTickerEnabled.tryEmit(playerState.isPlaying())
        }
    }

    private fun stopProgressTicker() {
        progressTickerEnabled.tryEmit(false)
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
        progressTickerEnabled.collectLatest { isEnabled ->
            if (!isEnabled) return@collectLatest
            while (true) {
                delay(PROGRESS_TICK_INTERVAL)
                playerStateMutable.update { state ->
                    state.withProgressAdvancedBy(PROGRESS_TICK_INTERVAL.inWholeMilliseconds.toInt())
                }
            }
        }
    }

    private fun PlayerStateData.isPlaying(): Boolean {
        return this is PlayerStateData.Active && playbackState.isPlaying
    }

    private fun updatePlaybackState(transform: PlaybackStateData.() -> PlaybackStateData) {
        playerStateMutable.update { state ->
            if (state !is PlayerStateData.Active) return@update state
            state.copy(
                playbackState = state.playbackState.transform()
            )
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
        val REFRESH_DELAY = 500.milliseconds
    }
}
