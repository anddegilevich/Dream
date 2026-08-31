package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistObject
import and.degilevich.dream.shared.core.service.test.api.fakePlaylistsApi
import and.degilevich.dream.shared.core.service.test.model.pagingPlaylistObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedPlaylistObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote.FakeSimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class PlaylistRemoteDataSourceImplTest {

    @Test
    fun `getCurrentUserPlaylists - successful response - returns items mapped via injected mapper`() = runTest {
        val playlistData = SimplifiedPlaylistData.empty()
        val content = Json.encodeToString(
            serializer = PagingPlaylistObject.serializer(),
            value = pagingPlaylistObject(
                items = listOf(simplifiedPlaylistObject(), simplifiedPlaylistObject())
            )
        )
        val dataSource = playlistRemoteDataSource(
            engine = respondingWith(content = content),
            simplifiedPlaylistOutputToDataMapper = FakeSimplifiedPlaylistOutputToDataMapper(
                onMap = { playlistData }
            )
        )

        val result = dataSource.getCurrentUserPlaylists(params = params())

        assertTrue(result.isSuccess)
        result.getOrNull()?.playlists shouldBe listOf(playlistData, playlistData)
    }

    @Test
    fun `getCurrentUserPlaylists - empty items - returns empty playlists`() = runTest {
        val content = Json.encodeToString(
            serializer = PagingPlaylistObject.serializer(),
            value = pagingPlaylistObject(items = emptyList())
        )
        val dataSource = playlistRemoteDataSource(engine = respondingWith(content = content))

        val result = dataSource.getCurrentUserPlaylists(params = params())

        assertTrue(result.isSuccess)
        result.getOrNull()?.playlists shouldBe emptyList()
    }

    @Test
    fun `getCurrentUserPlaylists - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = playlistRemoteDataSource(engine = respondingWith(content = "{}"))

        val result = dataSource.getCurrentUserPlaylists(params = params())

        assertTrue(result.isFailure)
    }

    @Test
    fun `getCurrentUserPlaylists - request - sends limit and offset as query params`() = runTest {
        val content = Json.encodeToString(
            serializer = PagingPlaylistObject.serializer(),
            value = pagingPlaylistObject(items = emptyList())
        )
        val engine = respondingWith(content = content)
        val dataSource = playlistRemoteDataSource(engine = engine)

        dataSource.getCurrentUserPlaylists(
            params = GetCurrentUserPlaylistsParams(
                limit = 7,
                offset = 14
            )
        )

        with(engine.requestHistory.first().url) {
            parameters["limit"] shouldBe "7"
            parameters["offset"] shouldBe "14"
            encodedPath shouldBe "/me/playlists"
        }
    }

    private fun params(
        limit: Int = 10,
        offset: Int = 0
    ) = GetCurrentUserPlaylistsParams(
        limit = limit,
        offset = offset
    )

    private fun playlistRemoteDataSource(
        engine: MockEngine,
        simplifiedPlaylistOutputToDataMapper: SimplifiedPlaylistOutputToDataMapper =
            FakeSimplifiedPlaylistOutputToDataMapper()
    ): PlaylistRemoteDataSourceImpl {
        val apiService = FakeApiService(onPlaylistsApi = { fakePlaylistsApi(engine = engine) })
        return PlaylistRemoteDataSourceImpl(
            apiService = apiService,
            simplifiedPlaylistOutputToDataMapper = simplifiedPlaylistOutputToDataMapper
        )
    }

    private fun respondingWith(content: String): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}
