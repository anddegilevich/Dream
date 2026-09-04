package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedIntent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedSideEffect
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.model.RecentlyPlayedState
import and.degilevich.dream.shared.feature.player.domain.api.usecase.GetRecentlyPlayedUseCase
import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedParams
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class RecentlyPlayedDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<RecentlyPlayedState, RecentlyPlayedIntent, RecentlyPlayedSideEffect>(
    componentContext = componentContext,
    stateConservator = RecentlyPlayedStateConservator()
) {

    private val getRecentlyPlayedUseCase: GetRecentlyPlayedUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: RecentlyPlayedIntent) {
        when (intent) {
            is RecentlyPlayedIntent.OnTrackClicked -> onTrackClicked(intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            getRecentlyPlayed()
        }
    }

    private fun getRecentlyPlayed() = scope.launch {
        val params = GetRecentlyPlayedParams(limit = RECENTLY_PLAYED_LIMIT)
        try {
            setLoading(true)
            withContext(context = Dispatchers.IO) { getRecentlyPlayedUseCase(params) }
                .onSuccess { result ->
                    setItems(items = result.items)
                }
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::getRecentlyPlayed
                    )
                }
        } finally {
            setLoading(false)
        }
    }

    private fun onTrackClicked(id: Identifier) {
        val playHistory = state().items.getById(id) ?: return
        navigateToTrackDetails(trackId = playHistory.track.id)
    }

    private fun navigateToTrackDetails(trackId: TrackId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(
                    trackId = trackId
                )
            )
        )
    }

    private fun setItems(items: List<PlayHistoryData>) = reduce {
        copy(items = items)
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private companion object {
        const val RECENTLY_PLAYED_LIMIT = 10
    }
}
