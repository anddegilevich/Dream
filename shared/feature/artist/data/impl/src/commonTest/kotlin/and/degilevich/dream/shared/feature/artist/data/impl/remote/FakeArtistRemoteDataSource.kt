package and.degilevich.dream.shared.feature.artist.data.impl.remote

import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistRemoteDataSource(
    private val onGetArtist: (GetArtistParams) -> Result<GetArtistResult> = { fakeImplementationError() },
    private val onGetArtistAlbums: (GetArtistAlbumsParams) -> Result<GetArtistAlbumsResult> = {
        fakeImplementationError()
    }
) : ArtistRemoteDataSource {

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> {
        return onGetArtist(params)
    }

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return onGetArtistAlbums(params)
    }
}
