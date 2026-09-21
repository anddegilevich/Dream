package and.degilevich.dream.shared.feature.track.domain.test.usecase

import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeGetSavedTracksUseCase(
    private val onInvoke: suspend (params: GetSavedTracksParams) -> Result<GetSavedTracksResult> = {
        fakeImplementationError()
    }
) : GetSavedTracksUseCase {

    override suspend fun invoke(params: GetSavedTracksParams): Result<GetSavedTracksResult> = onInvoke(params)
}
