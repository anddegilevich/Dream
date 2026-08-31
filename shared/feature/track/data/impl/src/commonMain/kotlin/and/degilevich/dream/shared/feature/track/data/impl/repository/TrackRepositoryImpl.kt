package and.degilevich.dream.shared.feature.track.data.impl.repository

import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.data.impl.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.data.impl.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult

internal class TrackRepositoryImpl(
    private val trackRemoteDataSource: TrackRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
) : TrackRepository {

    override suspend fun getTrack(params: GetTrackParams): Result<GetTrackResult> {
        return trackRemoteDataSource.getTrack(params = params)
    }

    override suspend fun getSavedTracks(params: GetSavedTracksParams): Result<GetSavedTracksResult> {
        return trackRemoteDataSource.getSavedTracks(params = params)
    }

    override suspend fun cacheTrack(track: TrackData) {
        trackLocalDataSource.saveTrack(track = track)
    }

    override suspend fun cacheTracks(tracks: List<TrackData>) {
        trackLocalDataSource.saveTracks(tracks = tracks)
    }
}
