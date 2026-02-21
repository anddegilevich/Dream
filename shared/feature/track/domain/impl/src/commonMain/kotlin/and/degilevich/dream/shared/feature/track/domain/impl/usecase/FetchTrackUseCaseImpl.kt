package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchTrackUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackResult
import and.degilevich.dream.shared.feature.track.source.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource

internal class FetchTrackUseCaseImpl(
    private val trackRemoteDataSource: TrackRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
) : FetchTrackUseCase {

    override suspend fun invoke(params: GetTrackParams): Result<GetTrackResult> {
        return trackRemoteDataSource.getTrack(params = params).onSuccess { result ->
            trackLocalDataSource.saveTrack(track = result.track)
        }
    }
}