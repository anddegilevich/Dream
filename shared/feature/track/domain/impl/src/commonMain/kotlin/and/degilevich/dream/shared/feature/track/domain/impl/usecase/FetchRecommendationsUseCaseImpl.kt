package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchRecommendationsUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getRecommendations.GetRecommendationsResult
import and.degilevich.dream.shared.feature.track.source.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource

internal class FetchRecommendationsUseCaseImpl(
    private val trackRemoteDataSource: TrackRemoteDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
) : FetchRecommendationsUseCase {

    override suspend fun invoke(params: GetRecommendationsParams): Result<GetRecommendationsResult> {
        return trackRemoteDataSource.getRecommendations(params = params).onSuccess { result ->
            trackLocalDataSource.saveTracks(tracks = result.tracks)
        }
    }
}