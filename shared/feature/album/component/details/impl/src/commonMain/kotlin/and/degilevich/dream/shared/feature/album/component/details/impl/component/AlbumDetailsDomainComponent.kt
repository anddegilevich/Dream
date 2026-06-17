package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.track.model.artifact.data.TrackId
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.ext.getById
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushToFront
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class AlbumDetailsDomainComponent(
    componentContext: ComponentContext,
    navArgs: AlbumDetailsNavArgs
) : BaseDomainComponent<
    AlbumDetailsState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect
    >(
    componentContext = componentContext,
    stateConservator = AlbumDetailsStateConservator(
        navArgs = navArgs
    )
) {

    private val getAlbumUseCase: GetAlbumUseCase by inject()
    private val getArtistsUseCase: GetArtistsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: AlbumDetailsIntent) {
        when (intent) {
            is AlbumDetailsIntent.OnBackClicked -> navigateBack()
            is AlbumDetailsIntent.OnArtistClicked -> onArtistClicked(id = intent.id)
            is AlbumDetailsIntent.OnTrackClicked -> onTrackClicked(id = intent.id)
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            getScreenData()
        }
    }

    private fun getScreenData() = scope.launch {
        try {
            setLoading(true)
            getAlbum().await().onFailure { error ->
                toastController.showRepeatToast(
                    error = error,
                    onRepeat = ::getScreenData
                )
                cancel()
            }
            getArtists().await().onFailure { error ->
                toastController.showRepeatToast(
                    error = error,
                    onRepeat = ::getScreenData
                )
            }
        } finally {
            setLoading(false)
        }
    }

    private fun getAlbum() = scope.async {
        val params = GetAlbumParams(
            id = state().navArgs.albumId
        )
        withContext(context = Dispatchers.IO) { getAlbumUseCase(params = params) }
            .onSuccess { result ->
                setAlbum(album = result.album)
            }
    }

    private fun getArtists() = scope.async {
        val params = GetArtistsParams(
            ids = state().album.artists.map { it.id }
        )
        withContext(context = Dispatchers.IO) { getArtistsUseCase(params = params) }
            .onSuccess { result ->
                setArtists(artists = result.artists)
            }
    }

    private fun onArtistClicked(id: Identifier) {
        val artist = state().artists.getById(id = id) ?: return
        navigateToArtistDetails(artistId = artist.id)
    }

    private fun onTrackClicked(id: Identifier) {
        val track = state().album.tracks.items.getById(id) ?: return
        navigateToTrackDetails(trackId = track.id)
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun navigateToArtistDetails(artistId: ArtistId) {
        navigator.screenNavigator.pushToFront(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(
                    artistId = artistId
                )
            )
        )
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

    private fun setAlbum(album: AlbumData) = reduce {
        copy(album = album)
    }

    private fun setArtists(artists: List<ArtistData>) = reduce {
        copy(artists = artists)
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }
}
