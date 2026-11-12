package and.degilevich.dream.shared.feature.player.component.player.impl.component

import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerIntent
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerSideEffect
import and.degilevich.dream.shared.feature.player.component.player.impl.component.model.PlayerState
import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.player.domain.model.core.api.method.setShuffle.SetShuffleParams
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
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

internal class PlayerDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<PlayerState, PlayerIntent, PlayerSideEffect>(
    componentContext = componentContext,
    stateConservator = PlayerStateConservator()
) {

    private val playerManager: PlayerManager by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: PlayerIntent) {
        when (intent) {
            is PlayerIntent.OnBackClicked -> navigateBack()
            is PlayerIntent.OnSkipToPreviousClicked -> skipToPrevious()
            is PlayerIntent.OnSkipToNextClicked -> skipToNext()
            is PlayerIntent.OnShuffleClicked -> toggleShuffle()
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
        val params = SetShuffleParams(
            isEnabled = !state().playbackState.isShuffling
        )
        withContext(Dispatchers.IO) {
            playerManager.setShuffle(params = params)
        }.onFailure { error ->
            toastController.showMessageToast(error = error)
        }
    }

    private fun skipToPrevious() = scope.launch {
        withContext(Dispatchers.IO) {
            playerManager.skipToPrevious()
        }.onFailure { error ->
            toastController.showMessageToast(error = error)
        }
    }

    private fun skipToNext() = scope.launch {
        withContext(Dispatchers.IO) {
            playerManager.skipToNext()
        }.onFailure { error ->
            toastController.showMessageToast(error = error)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun setPlaybackState(playbackState: PlaybackStateData) = reduce {
        copy(playbackState = playbackState)
    }
}
