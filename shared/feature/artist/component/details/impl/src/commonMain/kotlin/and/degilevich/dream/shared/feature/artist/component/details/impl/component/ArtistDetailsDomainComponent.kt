package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistTopTracksUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistTopTracks.GetArtistTopTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import com.arkivanov.essenty.lifecycle.doOnStop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class ArtistDetailsDomainComponent(
    componentContext: ComponentContext,
    navArgs: ArtistDetailsNavArgs
) : BaseDomainComponent<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect
    >(
    componentContext = componentContext,
    stateConservator = ArtistDetailsStateConservator(
        navArgs = navArgs
    )
) {

    private val fetchArtistUseCase: FetchArtistUseCase by inject()
    private val fetchArtistTopTracksUseCase: FetchArtistTopTracksUseCase by inject()
    private val fetchArtistAlbumsUseCase: FetchArtistAlbumsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: ArtistDetailsIntent) {
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
        doOnStop {
            setLoading(false)
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
            .onFailure { error ->
                toastController.showMessageToast(error)
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
            .onFailure { error ->
                toastController.showMessageToast(error)
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
            .onFailure { error ->
                toastController.showMessageToast(error)
            }
    }

    private fun navigateBack() {
        appNavigator.screenNavigator.pop()
    }

    private fun navigateToTrack(trackId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(trackId = trackId)
            )
        )
    }

    private fun navigateToAlbum(albumId: String) {
        appNavigator.screenNavigator.pushToFront(
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