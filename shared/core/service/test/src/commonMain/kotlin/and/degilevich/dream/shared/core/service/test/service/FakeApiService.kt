package and.degilevich.dream.shared.core.service.test.service

import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeApiService(
    private val onArtistsApi: () -> ArtistsApi = { fakeImplementationError() },
    private val onAlbumsApi: () -> AlbumsApi = { fakeImplementationError() },
    private val onTracksApi: () -> TracksApi = { fakeImplementationError() },
    private val onSearchApi: () -> SearchApi = { fakeImplementationError() }
) : ApiService {
    override val artistsApi: ArtistsApi get() = onArtistsApi()
    override val albumsApi: AlbumsApi get() = onAlbumsApi()
    override val tracksApi: TracksApi get() = onTracksApi()
    override val searchApi: SearchApi get() = onSearchApi()
}
