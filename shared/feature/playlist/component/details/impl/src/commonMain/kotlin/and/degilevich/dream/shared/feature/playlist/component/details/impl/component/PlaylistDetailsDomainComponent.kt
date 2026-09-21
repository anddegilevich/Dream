package and.degilevich.dream.shared.feature.playlist.component.details.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsIntent
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsSideEffect
import and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model.PlaylistDetailsState
import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSource
import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
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

internal class PlaylistDetailsDomainComponent(
    componentContext: ComponentContext,
    navArgs: PlaylistDetailsNavArgs
) : BaseDomainComponent<PlaylistDetailsState, PlaylistDetailsIntent, PlaylistDetailsSideEffect>(
    componentContext = componentContext,
    stateConservator = PlaylistDetailsStateConservator(navArgs = navArgs)
) {

    private val getPlaylistUseCase: GetPlaylistUseCase by inject()
    private val playlistTracksPagingSourceFactory: PlaylistTracksPagingSourceFactory by inject()
    private val playlistTracksPagingSource: PlaylistTracksPagingSource = playlistTracksPagingSourceFactory.create(
        componentContext = componentContext
    )

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: PlaylistDetailsIntent) {
        when (intent) {
            is PlaylistDetailsIntent.OnBackClicked -> navigateBack()
            is PlaylistDetailsIntent.OnNextPageRequested -> loadNextPage()
            is PlaylistDetailsIntent.OnTrackClicked -> onTrackClicked(id = intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            subscribeToPagingSource()
            loadPlaylist()
            loadFirstPage()
        }
    }

    private fun subscribeToPagingSource() = with(playlistTracksPagingSource) {
        setPlaylistId(id = state().navArgs.playlistId)
        data.onEach(::setTracks).launchIn(scope)
        totalCount.onEach(::setTotal).launchIn(scope)
        isLoading.onEach(::setLoadingTracks).launchIn(scope)
        errors.onEach(::showTracksError).launchIn(scope)
    }

    private fun loadPlaylist() = scope.launch {
        val params = GetPlaylistParams(id = state().navArgs.playlistId)
        withContext(context = Dispatchers.IO) { getPlaylistUseCase(params) }
            .onSuccess { result ->
                setPlaylist(playlist = result.playlist)
            }
            .onFailure { error ->
                toastController.showRepeatToast(
                    error = error,
                    onRepeat = ::loadPlaylist
                )
            }
    }

    private fun loadFirstPage() = scope.launch {
        withContext(context = Dispatchers.IO) { playlistTracksPagingSource.loadFirstPage() }
    }

    private fun loadNextPage() {
        scope.launch {
            withContext(context = Dispatchers.IO) { playlistTracksPagingSource.loadNextPage() }
        }
    }

    private fun onTrackClicked(id: Identifier) {
        val playlistTrack = state().tracks.getById(id = id) ?: return
        navigateToTrackDetails(trackId = playlistTrack.track.id)
    }

    private suspend fun showTracksError(error: Throwable) {
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

    private fun setPlaylist(playlist: PlaylistData) = reduce {
        copy(playlist = playlist)
    }

    private fun setTracks(tracks: List<PlaylistTrackData>) = reduce {
        copy(tracks = tracks)
    }

    private fun setTotal(total: Int) = reduce {
        copy(total = total)
    }

    private fun setLoadingTracks(isLoadingTracks: Boolean) = reduce {
        copy(isLoadingTracks = isLoadingTracks)
    }
}
