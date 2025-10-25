package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsState
import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchTrackUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.lifecycle.doOnCreate
import com.arkivanov.essenty.lifecycle.doOnStop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class TrackDetailsDomainComponent(
    componentContext: ComponentContext,
    navArgs: TrackDetailsNavArgs
) : BaseDomainComponent<
    TrackDetailsState,
    TrackDetailsIntent,
    TrackDetailsSideEffect
    >(
    componentContext = componentContext,
    stateConservator = TrackDetailsStateConservator(
        navArgs = navArgs
    )
) {
    private val fetchTrackUseCase: FetchTrackUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: TrackDetailsIntent) {
        when (intent) {
            is TrackDetailsIntent.OnBackClicked -> navigateBack()
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchTrack()
        }
        doOnStop {
            setLoading(false)
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
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::fetchTrack
                    )
                }
            setLoading(false)
        }
    }

    private fun navigateBack() {
        appNavigator.screenNavigator.pop()
    }

    private fun setLoading(isLoading: Boolean) {
        reduce { copy(isLoading = isLoading) }
    }

    private fun setTrack(track: TrackData) {
        reduce { copy(track = track) }
    }
}