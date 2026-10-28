package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerIntent
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerSideEffect
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.model.MiniPlayerState
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class MiniPlayerDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<MiniPlayerState, MiniPlayerIntent, MiniPlayerSideEffect>(
    componentContext = componentContext,
    stateConservator = MiniPlayerStateConservator()
) {

    private val playerManager: PlayerManager by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: MiniPlayerIntent) {
        when (intent) {
            is MiniPlayerIntent.OnViewClicked -> Unit
            is MiniPlayerIntent.OnSkipToPreviousClicked -> skipToPrevious()
            is MiniPlayerIntent.OnSkipToNextClicked -> skipToNext()
            is MiniPlayerIntent.OnShuffleClicked -> toggleShuffle()
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            observePlayerState()
        }
    }

    private fun observePlayerState() {
        playerManager.playerState
            .flowOn(Dispatchers.IO)
            .filterIsInstance<PlayerStateData.Active>()
            .onEach { activeState ->
                setPlaybackState(activeState.playbackState)
            }
            .launchIn(scope)
    }

    private fun toggleShuffle() = scope.launch {
        val params = SetShuffleParams(isEnabled = !state().playbackState.isShuffling)
        withContext(Dispatchers.IO) {
            playerManager.setShuffle(params = params)
        }.onFailure { error ->
            toastController.showMessageToast(error = error)
        }
    }

    private fun skipToPrevious() = scope.launch {
        withContext(Dispatchers.IO) { playerManager.skipToPrevious() }
    }

    private fun skipToNext() = scope.launch {
        withContext(Dispatchers.IO) { playerManager.skipToNext() }
    }

    private fun setPlaybackState(playbackState: PlaybackStateData) = reduce {
        copy(playbackState = playbackState)
    }
}
