package and.degilevich.dream.shared.feature.playlist.domain.test.usecase

import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistTracksUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeGetPlaylistTracksUseCase(
    private val onInvoke: suspend (params: GetPlaylistTracksParams) -> Result<GetPlaylistTracksResult> = {
        fakeImplementationError()
    }
) : GetPlaylistTracksUseCase {

    override suspend fun invoke(
        params: GetPlaylistTracksParams
    ): Result<GetPlaylistTracksResult> = onInvoke(params)
}
