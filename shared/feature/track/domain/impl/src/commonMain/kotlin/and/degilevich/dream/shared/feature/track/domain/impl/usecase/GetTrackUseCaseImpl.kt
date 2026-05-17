package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetTrackUseCase
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.method.getTrack.GetTrackResult

internal class GetTrackUseCaseImpl(
    private val trackRepository: TrackRepository
) : GetTrackUseCase {

    override suspend fun invoke(params: GetTrackParams): Result<GetTrackResult> {
        return trackRepository.getTrack(params = params).onSuccess { result ->
            trackRepository.cacheTrack(track = result.track)
        }
    }
}
