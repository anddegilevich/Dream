package and.degilevich.dream.shared.feature.artist.data.test.repository

import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistResult
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistRepository(
    private val onGetArtist: (params: GetArtistParams) -> Result<GetArtistResult> = { fakeImplementationError() },
    private val onGetArtistAlbums: (params: GetArtistAlbumsParams) -> Result<GetArtistAlbumsResult> = {
        fakeImplementationError()
    },
    private val onCacheArtist: (ArtistData) -> Unit = { fakeImplementationError() },
    private val onCacheArtists: (List<ArtistData>) -> Unit = { fakeImplementationError() }
) : ArtistRepository {

    override suspend fun getArtist(params: GetArtistParams): Result<GetArtistResult> = onGetArtist(params)

    override suspend fun getArtistAlbums(params: GetArtistAlbumsParams): Result<GetArtistAlbumsResult> {
        return onGetArtistAlbums(params)
    }

    override suspend fun cacheArtist(artist: ArtistData) = onCacheArtist(artist)

    override suspend fun cacheArtists(artists: List<ArtistData>) = onCacheArtists(artists)
}
