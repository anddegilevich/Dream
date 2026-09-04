package and.degilevich.dream.shared.feature.search.domain.impl.paging

import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.domain.test.usecase.FakeSearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchAlbumsData
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchArtistsData
import and.degilevich.dream.shared.feature.search.model.core.test.method.search.searchTracksData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import app.cash.turbine.test
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchPagingSourceImplTest {

    private val testDispatcher = StandardTestDispatcher()

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(dispatcher = testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadNextPage - query is set - requests every search type and interleaves the results`() = runTest {
        val artist = artistData(id = "artist-1")
        val track = trackData(id = "track-1")
        val album = simplifiedAlbumData(id = "album-1")
        val requestedParams = mutableListOf<SearchParams>()
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    Result.success(
                        SearchResult(
                            tracks = searchTracksData(
                                items = listOf(track),
                                total = TRACKS_TOTAL
                            ),
                            artists = searchArtistsData(
                                items = listOf(artist),
                                total = ARTISTS_TOTAL
                            ),
                            albums = searchAlbumsData(
                                items = listOf(album),
                                total = ALBUMS_TOTAL
                            )
                        )
                    )
                }
            )
        )
        pagingSource.setQuery(QUERY)

        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly listOf(
            SearchItemData.Artist(artist = artist),
            SearchItemData.Track(track = track),
            SearchItemData.Album(album = album)
        )
        pagingSource.totalCount.value shouldBe ARTISTS_TOTAL
        pagingSource.isLoading.value shouldBe false
        requestedParams shouldContainExactly listOf(
            SearchParams(
                query = QUERY,
                limit = SearchPagingSourceImpl.PAGE_SIZE,
                offset = 0,
                types = SearchPagingSourceImpl.SEARCH_TYPES
            )
        )
    }

    @Test
    fun `loadNextPage - called twice - requests the next offset and appends the page`() = runTest {
        val firstPageTracks = List(SearchPagingSourceImpl.PAGE_SIZE) { index ->
            trackData(id = "track-$index")
        }
        val secondPageTrack = trackData(id = "track-last")
        val requestedParams = mutableListOf<SearchParams>()
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    val tracks = if (params.offset == 0) firstPageTracks else listOf(secondPageTrack)
                    Result.success(
                        searchResult(
                            tracks = tracks,
                            total = TRACKS_TOTAL
                        )
                    )
                }
            )
        )
        pagingSource.setQuery(QUERY)

        pagingSource.loadNextPage()
        pagingSource.loadNextPage()

        pagingSource.data.value shouldContainExactly (firstPageTracks + secondPageTrack).map(SearchItemData::Track)
        requestedParams.map { params -> params.offset } shouldContainExactly listOf(
            0,
            SearchPagingSourceImpl.PAGE_SIZE
        )
    }

    @Test
    fun `loadNextPage - query is empty - does not invoke the use case`() = runTest {
        var invocationCount = 0
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(SearchResult.empty())
                }
            )
        )

        pagingSource.loadNextPage()

        invocationCount shouldBe 0
        pagingSource.data.value.shouldBeEmpty()
    }

    @Test
    fun `setQuery - new query - drops the previously loaded page and reloads from the first offset`() = runTest {
        val firstTrack = trackData(id = "track-1")
        val secondTrack = trackData(id = "track-2")
        val requestedParams = mutableListOf<SearchParams>()
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(
                onInvoke = { params ->
                    requestedParams.add(params)
                    val track = if (params.query == QUERY) firstTrack else secondTrack
                    Result.success(
                        searchResult(
                            tracks = listOf(track),
                            total = TRACKS_TOTAL
                        )
                    )
                }
            )
        )
        pagingSource.setQuery(QUERY)
        pagingSource.loadNextPage()

        pagingSource.setQuery(OTHER_QUERY)

        pagingSource.data.value.shouldBeEmpty()
        pagingSource.loadFirstPage()
        pagingSource.data.value shouldContainExactly listOf(SearchItemData.Track(track = secondTrack))
        requestedParams.map { params -> params.query to params.offset } shouldContainExactly listOf(
            QUERY to 0,
            OTHER_QUERY to 0
        )
    }

    @Test
    fun `setQuery - same query - keeps the already loaded page`() = runTest {
        val track = trackData(id = "track-1")
        var invocationCount = 0
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(
                onInvoke = {
                    invocationCount++
                    Result.success(
                        searchResult(
                            tracks = listOf(track),
                            total = TRACKS_TOTAL
                        )
                    )
                }
            )
        )
        pagingSource.setQuery(QUERY)
        pagingSource.loadNextPage()

        pagingSource.setQuery(QUERY)
        pagingSource.loadFirstPage()

        invocationCount shouldBe 1
        pagingSource.data.value shouldContainExactly listOf(SearchItemData.Track(track = track))
    }

    @Test
    fun `loadNextPage - use case fails - emits the error and stops loading`() = runTest {
        val error = IllegalStateException("network")
        val pagingSource = createPagingSource(
            searchUseCase = FakeSearchUseCase(onInvoke = { Result.failure(error) })
        )
        pagingSource.setQuery(QUERY)

        pagingSource.errors.test {
            pagingSource.loadNextPage()
            awaitItem() shouldBe error
        }
        pagingSource.data.value.shouldBeEmpty()
        pagingSource.isLoading.value shouldBe false
    }

    private fun createPagingSource(
        searchUseCase: FakeSearchUseCase = FakeSearchUseCase()
    ) = SearchPagingSourceImpl(
        componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
        searchUseCase = searchUseCase
    )

    private fun searchResult(
        tracks: List<TrackData>,
        total: Int
    ) = SearchResult(
        tracks = searchTracksData(
            items = tracks,
            total = total
        ),
        artists = searchArtistsData(
            items = emptyList(),
            total = 0
        ),
        albums = searchAlbumsData(
            items = emptyList(),
            total = 0
        )
    )

    private companion object {
        const val QUERY = "Beatles"
        const val OTHER_QUERY = "Queen"
        const val TRACKS_TOTAL = 30
        const val ARTISTS_TOTAL = 50
        const val ALBUMS_TOTAL = 40
    }
}
