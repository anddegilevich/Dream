package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.data.test.repository.FakeSearchRepository
import and.degilevich.dream.shared.feature.search.model.core.api.dictionary.SearchType
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchTracksData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class SearchUseCaseImplTest {

    @Test
    fun `invoke - search succeeds - returns the result unchanged`() = runTest {
        val artist = artistData(id = "artist-1")
        val album = simplifiedAlbumData(id = "album-1")
        val track = trackData(id = "track-1")
        val searchResult = SearchResult(
            tracks = SearchTracksData(
                items = listOf(track),
                total = 1
            ),
            artists = SearchArtistsData(
                items = listOf(artist),
                total = 1
            ),
            albums = SearchAlbumsData(
                items = listOf(album),
                total = 1
            )
        )
        val useCase = createSearchUseCase(
            searchRepository = FakeSearchRepository(onSearch = { Result.success(searchResult) })
        )
        val result = useCase(params())
        result shouldBe Result.success(searchResult)
    }

    @Test
    fun `invoke - search fails - returns failure`() = runTest {
        val error = IllegalStateException("network error")
        val useCase = createSearchUseCase(
            searchRepository = FakeSearchRepository(onSearch = { Result.failure(error) })
        )
        val result = useCase(params())
        assertTrue(result.isFailure)
    }

    @Test
    fun `invoke - any params - passes them to the repository unchanged`() = runTest {
        val receivedParams = mutableListOf<SearchParams>()
        val useCase = createSearchUseCase(
            searchRepository = FakeSearchRepository(
                onSearch = { params ->
                    receivedParams.add(params)
                    Result.success(
                        SearchResult(
                            tracks = SearchTracksData.empty(),
                            artists = SearchArtistsData.empty(),
                            albums = SearchAlbumsData.empty()
                        )
                    )
                }
            )
        )
        val params = params()
        useCase(params)
        receivedParams shouldBe listOf(params)
    }

    private fun params() = SearchParams(
        query = "query",
        limit = 10,
        offset = 0,
        types = listOf(SearchType.TRACK)
    )

    private fun createSearchUseCase(
        searchRepository: SearchRepository = FakeSearchRepository()
    ) = SearchUseCaseImpl(
        searchRepository = searchRepository
    )
}
