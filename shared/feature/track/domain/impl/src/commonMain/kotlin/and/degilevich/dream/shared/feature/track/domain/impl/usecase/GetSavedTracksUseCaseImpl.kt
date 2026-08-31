package and.degilevich.dream.shared.feature.track.domain.impl.usecase

import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult

internal class GetSavedTracksUseCaseImpl(
    private val trackRepository: TrackRepository
) : GetSavedTracksUseCase {

    override suspend fun invoke(params: GetSavedTracksParams): Result<GetSavedTracksResult> {
        return trackRepository.getSavedTracks(params = params)
            .onSuccess { result ->
                trackRepository.cacheTracks(
                    tracks = result.tracks.map { savedTrack -> savedTrack.track }
                )
            }
    }
}
