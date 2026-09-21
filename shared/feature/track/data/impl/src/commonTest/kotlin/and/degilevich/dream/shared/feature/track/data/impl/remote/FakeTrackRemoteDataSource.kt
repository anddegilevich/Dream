package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackRemoteDataSource(
    private val onGetTrack: (GetTrackParams) -> Result<GetTrackResult> = { fakeImplementationError() },
    private val onGetSavedTracks: (GetSavedTracksParams) -> Result<GetSavedTracksResult> = {
        fakeImplementationError()
    }
) : TrackRemoteDataSource {

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> {
        return onGetTrack(params)
    }

    override suspend fun getSavedTracks(params: GetSavedTracksParams): Result<GetSavedTracksResult> {
        return onGetSavedTracks(params)
    }
}
