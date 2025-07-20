package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchAlbumUseCase
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumParams
import and.degilevich.dream.shared.feature.album.model.core.api.request.getAlbum.GetAlbumResult
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistsUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtists.GetArtistsResult
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

internal class AlbumDetailsExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<AlbumDetailsState, AlbumDetailsIntent, AlbumDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val fetchAlbumUseCase: FetchAlbumUseCase by inject()
    private val fetchArtistsUseCase: FetchArtistsUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun executeIntent(intent: AlbumDetailsIntent) {
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
    }

    private suspend fun fetchArtists(artistsIds: List<String>): Result<GetArtistsResult> {
        val params = GetArtistsParams(
            ids = artistsIds
        )
        return withContext(context = Dispatchers.IO) { fetchArtistsUseCase(params = params) }
            .onSuccess { result ->
                setArtists(artists = result.artists)
            }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun navigateToArtistDetails(artistId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(
                    artistId = artistId
                )
            )
        )
    }

    private fun navigateToTrackDetails(trackId: String) {
        navigator.screenNavigator.pushNew(
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