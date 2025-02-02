package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsMessage
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtist.GetArtistRequest
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.executor.AbstractExecutor
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.dispatcher.ext.flow.flowOnBackground
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import com.arkivanov.essenty.lifecycle.doOnStart
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsExecutor(
    lifecycle: ExtendedLifecycle
) : AbstractExecutor<ArtistDetailsState, ArtistDetailsIntent, ArtistDetailsSideEffect, ArtistDetailsMessage>(),
    KoinComponent {

    private val navigator: DreamNavigator by inject()
    private val getArtistFlowUseCase: GetArtistFlowUseCase by inject()
    private val getArtistsFlowUseCase: GetArtistsFlowUseCase by inject()

    init {
        subscribeToLifecycle(lifecycle)
    }

    override fun executeIntent(intent: ArtistDetailsIntent) {
        when (intent) {
            is ArtistDetailsIntent.OnBackCLicked -> navigateBack()
            is ArtistDetailsIntent.OnSimilarArtistClicked -> navigateToSimilarArtist(intent.id)
        }
    }

    private fun subscribeToLifecycle(lifecycle: ExtendedLifecycle) {
        lifecycle.doOnStart {
            fetchArtist()
            fetchSimilarArtists()
        }
    }

    private fun fetchArtist() {
        scope.launch {
            setLoading(true)
            getArtistFlowUseCase(
                request = GetArtistRequest(
                    id = state().config.artistId
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
        dispatch(ArtistDetailsMessage.SetArtist(artist))
    }

    private fun fetchSimilarArtists() {
        scope.launch {
            setLoading(true)
            getArtistsFlowUseCase(request = GetArtistsRequest())
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
        dispatch(ArtistDetailsMessage.SetSimilarArtists(artists))
    }

    private fun setLoading(isLoading: Boolean) {
        dispatch(ArtistDetailsMessage.SetLoading(isLoading))
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun navigateToSimilarArtist(artistId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.ArtistDetails(
                artistId = artistId
            )
        )
    }
}