package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseDomainComponent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsState
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetTrackUseCase
import and.degilevich.dream.shared.feature.track.model.core.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.lifecycle.doOnCreate
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
    stateConservator = TrackDetailsStateConservator(navArgs = navArgs)
) {
    private val getTrackUseCase: GetTrackUseCase by inject()

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
            getTrack()
        }
    }

    private fun getTrack() = scope.launch {
        val params = GetTrackParams(
            id = state().navArgs.trackId
        )
        try {
            setLoading(true)
            withContext(Dispatchers.IO) { getTrackUseCase(params) }
                .onSuccess { result ->
                    setTrack(track = result.track)
                }
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::getTrack
                    )
                }
        } finally {
            setLoading(false)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private fun setTrack(track: TrackData) = reduce {
        copy(track = track)
    }
}
