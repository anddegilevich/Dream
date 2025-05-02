package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.ext.flow.flowOnBackground
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.AppNavigator
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsExecutor(
    lifecycle: Lifecycle
) : ExecutorAbs<ArtistDetailsState, ArtistDetailsIntent, ArtistDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val getArtistFlowUseCase: GetArtistFlowUseCase by inject()
    private val getArtistsFlowUseCase: GetArtistsFlowUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchArtist()
            fetchSimilarArtists()
        }
    }

    override fun executeIntent(intent: ArtistDetailsIntent) {
        when (intent) {
            is ArtistDetailsIntent.OnBackCLicked -> navigateBack()
            is ArtistDetailsIntent.OnSimilarArtistClicked -> navigateToSimilarArtist(intent.id)
        }
    }

    private fun fetchArtist() {
        scope.launch {
            setLoading(true)
            getArtistFlowUseCase(
                params = GetArtistParams(
                    id = state().navArgs.artistId
                )
            )
                .flowOnBackground()
                .collect { result ->
                    result.onSuccess { artist ->
                        setArtist(artist)
                    }
                }
        }.invokeOnCompletion {
            setLoading(false)
        }
    }

    private fun setArtist(artist: ArtistData) {
        reduce {
            copy(
                artist = artist
            )
        }
    }

    private fun fetchSimilarArtists() {
        scope.launch {
            setLoading(true)
            getArtistsFlowUseCase(
                params = GetArtistsParams(
                    ids = listOf(
                        "2CIMQHirSU0MQqyYHq0eOx",
                        "57dN52uHvrHOxijzpIgu3E",
                        "1vCWHaC5f2uS3yhpwWbIA6"
                    )
                )
            )
                .flowOnBackground()
                .collect { result ->
                    result.onSuccess { artists ->
                        setSimilarArtists(artists)
                    }
                }
        }.invokeOnCompletion {
            setLoading(false)
        }
    }

    private fun setSimilarArtists(artists: List<ArtistData>) {
        reduce {
            copy(
                similarArtists = artists
            )
        }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce {
            copy(
                isLoading = isLoading
            )
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun navigateToSimilarArtist(artistId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.ArtistDetails(
                navArgs = ArtistDetailsNavArgs(
                    artistId = artistId
                )
            )
        )
    }
}