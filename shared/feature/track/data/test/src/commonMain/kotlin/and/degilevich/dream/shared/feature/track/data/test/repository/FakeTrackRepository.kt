package and.degilevich.dream.shared.feature.track.data.test.repository

import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeTrackRepository(
    private val onGetTrack: (params: GetTrackParams) -> Result<GetTrackResult> = { fakeImplementationError() },
    private val onGetSavedTracks: (params: GetSavedTracksParams) -> Result<GetSavedTracksResult> = {
        fakeImplementationError()
    },
    private val onCacheTrack: (TrackData) -> Unit = { fakeImplementationError() },
    private val onCacheTracks: (List<TrackData>) -> Unit = { fakeImplementationError() }
) : TrackRepository {

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> = onGetTrack(params)

    override suspend fun getSavedTracks(
        params: GetSavedTracksParams
    ): Result<GetSavedTracksResult> = onGetSavedTracks(params)

    override suspend fun cacheTrack(track: TrackData) = onCacheTrack(track)

    override suspend fun cacheTracks(tracks: List<TrackData>) = onCacheTracks(tracks)
}
