package and.degilevich.dream.shared.feature.track.component.details.impl.store

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchTrackUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
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
import kotlin.getValue

internal class TrackDetailsExecutor(
    lifecycle: Lifecycle
) : AbstractExecutor<TrackDetailsState, TrackDetailsIntent, TrackDetailsSideEffect>(lifecycle),
    KoinComponent {

    private val navigator: AppNavigator by inject()
    private val fetchTrackUseCase: FetchTrackUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun executeIntent(intent: TrackDetailsIntent) {
        when (intent) {
            is TrackDetailsIntent.OnBackClicked -> navigateBack()
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchTrack()
        }
    }

    private fun fetchTrack() {
        scope.launch {
            setLoading(true)
            val params = GetTrackParams(
                id = state().navArgs.trackId
            )
            withContext(Dispatchers.IO) { fetchTrackUseCase(params) }
                .onSuccess { result ->
                    setTrack(track = result.track)
                }
            setLoading(false)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }

    private fun setTrack(track: TrackData) {
        reduce { copy(track = track) }
    }
}