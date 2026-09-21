package and.degilevich.dream.shared.feature.playlist.domain.test.usecase

import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistUseCase
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeGetPlaylistUseCase(
    private val onInvoke: suspend (params: GetPlaylistParams) -> Result<GetPlaylistResult> = {
        fakeImplementationError()
    }
) : GetPlaylistUseCase {

    override suspend fun invoke(params: GetPlaylistParams): Result<GetPlaylistResult> = onInvoke(params)
}
