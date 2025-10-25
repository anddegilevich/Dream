package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtists.GetArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids
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

    private val fetchAlbumUseCase: FetchAlbumUseCase by inject()
    private val fetchArtistsUseCase: FetchArtistsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: AlbumDetailsIntent) {
        when (intent) {
            is AlbumDetailsIntent.OnBackClicked -> navigateBack()
            is AlbumDetailsIntent.OnArtistClicked -> navigateToArtistDetails(intent.id)
            is AlbumDetailsIntent.OnTrackClicked -> navigateToTrackDetails(intent.id)
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
            fetchAlbum().onSuccess { result ->
                fetchArtists(
                    artistsIds = result.album.artists.ids()
                )
            }
            setLoading(false)
        }
    }

    private suspend fun fetchAlbum(): Result<GetAlbumResult> {
        val params = GetAlbumParams(
            id = state().navArgs.albumId
        )
        return withContext(context = Dispatchers.IO) { fetchAlbumUseCase(params = params) }
            .onSuccess { result ->
                setAlbum(album = result.album)
            }
            .onFailure { error ->
                toastController.showRepeatToast(
                    error = error,
                    onRepeat = ::fetchScreenData
                )
            }
    }

    private suspend fun fetchArtists(artistsIds: List<String>): Result<GetArtistsResult> {
        val params = GetArtistsParams(
            ids = artistsIds
        )
        return withContext(context = Dispatchers.IO) { fetchArtistsUseCase(params = params) }
            .onSuccess { result ->
                setArtists(artists = result.artists)
            }
            .onFailure { error ->
                toastController.showRepeatToast(
                    error = error,
                    onRepeat = ::fetchScreenData
                )
            }
    }

    private fun navigateBack() {
        appNavigator.screenNavigator.pop()
    }

    private fun navigateToArtistDetails(artistId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(
                    artistId = artistId
                )
            )
        )
    }

    private fun navigateToTrackDetails(trackId: String) {
        appNavigator.screenNavigator.pushToFront(
            ScreenConfig.TrackDetails(
                navArgs = TrackDetailsNavArgs(
                    trackId = trackId
                )
            )
        )
    }

    private fun setAlbum(album: AlbumData) {
        reduce { copy(album = album) }
    }

    private fun setArtists(artists: List<ArtistData>) {
        reduce { copy(artists = artists) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }
}