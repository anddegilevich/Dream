package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.data.test.repository.FakeAlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.data.test.repository.FakeArtistRepository
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.data.test.repository.FakeSearchRepository
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.data.test.repository.FakeTrackRepository
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class SearchUseCaseImplTest {

    @Test
    fun `invoke - search succeeds - caches artists albums and tracks from the result`() = runTest {
        val artist = artistData(id = "artist-1")
        val album = simplifiedAlbumData(id = "album-1")
        val track = trackData(id = "track-1")
        val searchResult = SearchResult(
            tracks = SearchTracksData(items = listOf(track)),
            artists = SearchArtistsData(items = listOf(artist)),
            albums = SearchAlbumsData(items = listOf(album))
        )
        val cachedArtists = mutableListOf<ArtistData>()
        val cachedAlbums = mutableListOf<SimplifiedAlbumData>()
        val cachedTracks = mutableListOf<TrackData>()
        val useCase = createSearchUseCase(
            searchRepository = FakeSearchRepository(onSearch = { Result.success(searchResult) }),
            artistRepository = FakeArtistRepository(onCacheArtists = { cachedArtists.addAll(it) }),
            albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedAlbums.addAll(it) }),
            trackRepository = FakeTrackRepository(onCacheTracks = { cachedTracks.addAll(it) })
        )
        val params = SearchParams(
            query = "query",
            limit = 10,
            offset = 0,
            types = listOf(SearchType.TRACK)
        )
        val result = useCase(params)
        result shouldBe Result.success(searchResult)
        cachedArtists shouldBe listOf(artist)
        cachedAlbums shouldBe listOf(album)
        cachedTracks shouldBe listOf(track)
    }

    @Test
    fun `invoke - search fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val cachedArtists = mutableListOf<ArtistData>()
        val cachedAlbums = mutableListOf<SimplifiedAlbumData>()
        val cachedTracks = mutableListOf<TrackData>()
        val useCase = createSearchUseCase(
            searchRepository = FakeSearchRepository(onSearch = { Result.failure(error) }),
            artistRepository = FakeArtistRepository(onCacheArtists = { cachedArtists.addAll(it) }),
            albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedAlbums.addAll(it) }),
            trackRepository = FakeTrackRepository(onCacheTracks = { cachedTracks.addAll(it) })
        )
        val params = SearchParams(
            query = "query",
            limit = 10,
            offset = 0,
            types = listOf(SearchType.TRACK)
        )
        val result = useCase(params)
        assertTrue(result.isFailure)
        cachedArtists shouldBe emptyList()
        cachedAlbums shouldBe emptyList()
        cachedTracks shouldBe emptyList()
    }

    private fun createSearchUseCase(
        searchRepository: SearchRepository = FakeSearchRepository(),
        artistRepository: ArtistRepository = FakeArtistRepository(),
        albumRepository: AlbumRepository = FakeAlbumRepository(),
        trackRepository: TrackRepository = FakeTrackRepository()
    ) = SearchUseCaseImpl(
        searchRepository = searchRepository,
        artistRepository = artistRepository,
        albumRepository = albumRepository,
        trackRepository = trackRepository
    )
}
