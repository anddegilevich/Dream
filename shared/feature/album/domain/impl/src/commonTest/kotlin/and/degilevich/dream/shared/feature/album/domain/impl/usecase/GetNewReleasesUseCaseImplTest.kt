package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.test.repository.FakeAlbumRepository
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.search.data.test.repository.FakeSearchRepository
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetNewReleasesUseCaseImplTest {

    @Test
    fun `invoke - search succeeds - sends new-releases query and caches unwrapped albums`() = runTest {
        val album = simplifiedAlbumData(
            id = "album-1",
            albumType = AlbumType.ALBUM
        )
        val searchRepository = FakeSearchRepository(
            onSearch = {
                Result.success(
                    SearchResult(
                        tracks = SearchTracksData.empty(),
                        artists = SearchArtistsData.empty(),
                        albums = SearchAlbumsData(items = listOf(album))
                    )
                )
            }
        )
        val cachedSimplifiedAlbums = mutableListOf<SimplifiedAlbumData>()
        val albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedSimplifiedAlbums.addAll(it) })
        val useCase = GetNewReleasesUseCaseImpl(
            searchRepository = searchRepository,
            albumRepository = albumRepository
        )
        val params = GetNewReleasesParams(
            limit = 20,
            offset = 0
        )
        val result = useCase(params)
        result shouldBe Result.success(GetNewReleasesResult(albums = listOf(album)))
        cachedSimplifiedAlbums shouldBe listOf(album)
    }

    @Test
    fun `invoke - search fails - returns failure without caching`() = runTest {
        val error = IllegalStateException("network error")
        val searchRepository = FakeSearchRepository(onSearch = { Result.failure(error) })
        val cachedSimplifiedAlbums = mutableListOf<SimplifiedAlbumData>()
        val albumRepository = FakeAlbumRepository(onCacheAlbums = { cachedSimplifiedAlbums.addAll(it) })
        val useCase = GetNewReleasesUseCaseImpl(
            searchRepository = searchRepository,
            albumRepository = albumRepository
        )
        val params = GetNewReleasesParams(
            limit = 20,
            offset = 0
        )
        val result = useCase(params)
        assertTrue(result.isFailure)
        cachedSimplifiedAlbums shouldBe emptyList()
    }
}
