package and.degilevich.dream.shared.feature.album.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesParams
import and.degilevich.dream.shared.feature.album.model.core.api.method.getNewReleases.GetNewReleasesResult
import and.degilevich.dream.shared.feature.search.data.test.repository.FakeSearchRepository
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GetNewReleasesUseCaseImplTest {

    @Test
    fun `invoke - search succeeds - sends new-releases query and returns unwrapped albums`() = runTest {
        val album = simplifiedAlbumData(
            id = "album-1",
            albumType = AlbumType.ALBUM
        )
        val receivedParams = mutableListOf<SearchParams>()
        val searchRepository = FakeSearchRepository(
            onSearch = { params ->
                receivedParams.add(params)
                Result.success(
                    SearchResult(
                        tracks = SearchTracksData.empty(),
                        artists = SearchArtistsData.empty(),
                        albums = SearchAlbumsData(
                            items = listOf(album),
                            total = 1
                        )
                    )
                )
            }
        )
        val useCase = GetNewReleasesUseCaseImpl(searchRepository = searchRepository)
        val params = GetNewReleasesParams(
            limit = 20,
            offset = 0
        )
        val result = useCase(params)
        result shouldBe Result.success(GetNewReleasesResult(albums = listOf(album)))
        receivedParams.single().query shouldBe "tag:new"
    }

    @Test
    fun `invoke - search fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val searchRepository = FakeSearchRepository(onSearch = { Result.failure(error) })
        val useCase = GetNewReleasesUseCaseImpl(searchRepository = searchRepository)
        val params = GetNewReleasesParams(
            limit = 20,
            offset = 0
        )
        val result = useCase(params)
        assertTrue(result.isFailure)
    }
}
