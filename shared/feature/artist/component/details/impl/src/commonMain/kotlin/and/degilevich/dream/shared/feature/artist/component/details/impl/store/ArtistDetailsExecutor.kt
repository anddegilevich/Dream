package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistUseCase
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.request.getArtist.GetArtistParams
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.AbstractExecutor
import and.degilevich.dream.shared.navigation.api.AppNavigator
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<ArtistDetailsState, ArtistDetailsIntent, ArtistDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val fetchArtistUseCase: FetchArtistUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun executeIntent(intent: ArtistDetailsIntent) {
        when (intent) {
            is ArtistDetailsIntent.OnBackClicked -> navigateBack()
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchArtist()
        }
    }

    private fun fetchArtist() {
        scope.launch {
            setLoading(true)
            val params = GetArtistParams(
                id = state().navArgs.artistId
            )
            withContext(context = Dispatchers.IO) { fetchArtistUseCase(params = params) }
                .onSuccess { result ->
                    setArtist(artist = result.artist)
                }
            setLoading(false)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun setArtist(artist: ArtistData) {
        reduce { copy(artist = artist) }
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }
}