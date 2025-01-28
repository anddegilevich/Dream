package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListMessage
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.GetArtistsRequest
import and.degilevich.dream.shared.feature.artist.model.core.ArtistData
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import and.degilevich.dream.shared.foundation.dispatcher.ext.flow.flowOnBackground
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//FIXME: Subscribe to lifecycle
internal class ArtistListExecutor(
    lifecycle: ExtendedLifecycle
) : CoroutineExecutor<ArtistListIntent, Nothing, ArtistListState, ArtistListMessage, Nothing>(
    mainContext = DefaultKMPDispatchers.main
),
    KoinComponent {

    private val navigator: DreamNavigator by inject()
    private val getArtistsFlowUseCase: GetArtistsFlowUseCase by inject()

    override fun executeIntent(intent: ArtistListIntent) {
        when (intent) {
            is ArtistListIntent.OnArtistClicked -> {
                navigateToArtist(intent.id)
            }
        }
    }

    init {
        lifecycle.subscribe(
            onCreate = {
                fetchArtists()
            }
        )
    }

    private fun fetchArtists() {
        scope.launch {
            setLoading(true)
            getArtistsFlowUseCase(
                request = GetArtistsRequest()
            )
                .flowOnBackground()
                .collect { result ->
                    result.onSuccess { artists ->
                        setArtists(artists)
                    }
                }
        }.invokeOnCompletion {
            setLoading(false)
        }
    }

    private fun setArtists(artists: List<ArtistData>) {
        dispatch(ArtistListMessage.SetArtists(artists))
    }

    private fun setLoading(isLoading: Boolean) {
        dispatch(ArtistListMessage.SetLoading(isLoading))
    }

    private fun navigateToArtist(artistId: String) {
        navigator.screenNavigator.pushNew(
            ScreenConfig.ArtistDetails(
                artistId = artistId
            )
        )
    }
}