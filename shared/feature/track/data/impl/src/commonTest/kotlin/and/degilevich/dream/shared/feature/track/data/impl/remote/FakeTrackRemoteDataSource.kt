package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackRemoteDataSource(
    private val onGetTrack: (GetTrackParams) -> Result<GetTrackResult> = { fakeImplementationError() }
) : TrackRemoteDataSource {

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> {
        return onGetTrack(params)
    }
}
