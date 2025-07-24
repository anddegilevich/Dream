package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistTopTracksUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<ArtistDetailsState, ArtistDetailsIntent, ArtistDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val fetchArtistUseCase: FetchArtistUseCase by inject()
    private val fetchArtistTopTracksUseCase: FetchArtistTopTracksUseCase by inject()
    private val fetchArtistAlbumsUseCase: FetchArtistAlbumsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun executeIntent(intent: ArtistDetailsIntent) {
        when (intent) {
            is ArtistDetailsIntent.OnBackClicked -> navigateBack()
            is ArtistDetailsIntent.OnTrackClicked -> navigateToTrack(trackId = intent.id)
            is ArtistDetailsIntent.OnAlbumClicked -> navigateToAlbum(albumId = intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchScreenData()
        }
    }

    private fun fetchScreenData() {
        scope.launch {
            setLoading(true)
            supervisorScope {
                launch { fetchArtist() }
                launch { fetchTopTracks() }
                launch { fetchAlbums() }
            }
            setLoading(false)
        }
    }

    private suspend fun fetchArtist() {
        val params = GetArtistParams(
            id = state().navArgs.artistId
        )
        withContext(context = Dispatchers.IO) { fetchArtistUseCase(params = params) }
            .onSuccess { result ->
                setArtist(artist = result.artist)
            }
    }

    private suspend fun fetchTopTracks() {
        val params = GetArtistTopTracksParams(
            id = state().navArgs.artistId
        )
        withContext(context = Dispatchers.IO) { fetchArtistTopTracksUseCase(params = params) }
            .onSuccess { result ->
                setTopTracks(tracks = result.tracks)
            }
    }

    private suspend fun fetchAlbums() {
        val params = GetArtistAlbumsParams(
            id = state().navArgs.artistId,
            limit = ALBUMS_LIMIT,
            offset = 0
        )
        withContext(context = Dispatchers.IO) { fetchArtistAlbumsUseCase(params = params) }
            .onSuccess { result ->
                setAlbums(albums = result.items)
            }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun navigateToTrack(trackId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(trackId = trackId)
            )
        )
    }

    private fun navigateToAlbum(albumId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.AlbumDetails(
                navArgs = AlbumDetailsNavArgs(albumId = albumId)
            )
        )
    }

    private fun setArtist(artist: ArtistData) {
        reduce { copy(artist = artist) }
    }

    private fun setTopTracks(tracks: List<TrackData>) {
        reduce { copy(topTracks = tracks) }
    }

    private fun setAlbums(albums: List<AlbumSimplifiedData>) {
        reduce { copy(albums = albums) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }

    private companion object {
        const val ALBUMS_LIMIT = 10
    }
}