package and.degilevich.dream.shared.feature.track.component.liked.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksIntent
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksSideEffect
import and.degilevich.dream.shared.feature.track.component.liked.impl.component.model.LikedTracksState
import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSource
import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.data.SavedTrackData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class LikedTracksDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<LikedTracksState, LikedTracksIntent, LikedTracksSideEffect>(
    componentContext = componentContext,
    stateConservator = LikedTracksStateConservator()
) {

    private val likedTracksPagingSourceFactory: LikedTracksPagingSourceFactory by inject()
    private val likedTracksPagingSource: LikedTracksPagingSource = likedTracksPagingSourceFactory.create(
        componentContext = componentContext
    )

    init {
        subscribeToPagingSource()
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: LikedTracksIntent) {
        when (intent) {
            is LikedTracksIntent.OnBackClicked -> navigateBack()
            is LikedTracksIntent.OnNextPageRequested -> loadNextPage()
            is LikedTracksIntent.OnTrackClicked -> onTrackClicked(id = intent.id)
        }
    }

    private fun subscribeToPagingSource() = with(likedTracksPagingSource) {
        data.onEach(::setTracks).launchIn(scope)
        totalCount.onEach(::setTotal).launchIn(scope)
        isLoading.onEach(::setLoadingTracks).launchIn(scope)
        errors.onEach(::showError).launchIn(scope)
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            loadFirstPage()
        }
    }

    private fun loadFirstPage() = scope.launch {
        withContext(context = Dispatchers.IO) { likedTracksPagingSource.loadFirstPage() }
    }

    private fun loadNextPage() {
        scope.launch {
            withContext(context = Dispatchers.IO) { likedTracksPagingSource.loadNextPage() }
        }
    }

    private fun onTrackClicked(id: Identifier) {
        val savedTrack = state().tracks.getById(id = id) ?: return
        navigateToTrackDetails(trackId = savedTrack.track.id)
    }

    private suspend fun showError(error: Throwable) {
        toastController.showRepeatToast(
            error = error,
            onRepeat = ::loadNextPage
        )
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
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

    private fun setTracks(tracks: List<SavedTrackData>) = reduce {
        copy(tracks = tracks)
    }

    private fun setTotal(total: Int) = reduce {
        copy(total = total)
    }

    private fun setLoadingTracks(isLoadingTracks: Boolean) = reduce {
        copy(isLoadingTracks = isLoadingTracks)
    }
}
