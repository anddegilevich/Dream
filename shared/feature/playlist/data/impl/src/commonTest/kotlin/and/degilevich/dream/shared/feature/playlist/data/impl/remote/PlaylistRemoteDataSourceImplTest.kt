package and.degilevich.dream.shared.feature.playlist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingPlaylistTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistObject
import and.degilevich.dream.shared.core.service.test.api.fakePlaylistsApi
import and.degilevich.dream.shared.core.service.test.model.pagingPlaylistObject
import and.degilevich.dream.shared.core.service.test.model.pagingPlaylistTrackObject
import and.degilevich.dream.shared.core.service.test.model.playlistObject
import and.degilevich.dream.shared.core.service.test.model.playlistTrackObject
import and.degilevich.dream.shared.core.service.test.model.simplifiedPlaylistObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote.FakePlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote.FakePlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote.FakeSimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getCurrentUserPlaylists.GetCurrentUserPlaylistsParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylist.GetPlaylistParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksParams
import and.degilevich.dream.shared.feature.playlist.model.core.api.method.getPlaylistTracks.GetPlaylistTracksResult
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistData
import and.degilevich.dream.shared.feature.playlist.model.core.test.data.playlistTrackData
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

    @Test
    fun `getPlaylist - successful response - returns playlist mapped via injected mapper`() = runTest {
        val playlist = playlistData(id = "playlist-1")
        val content = Json.encodeToString(
            serializer = PlaylistObject.serializer(),
            value = playlistObject()
        )
        val dataSource = playlistRemoteDataSource(
            engine = respondingWith(content = content),
            playlistOutputToDataMapper = FakePlaylistOutputToDataMapper(onMap = { playlist })
        )

        val result = dataSource.getPlaylist(params = GetPlaylistParams(id = PlaylistId(value = "playlist-1")))

        assertTrue(result.isSuccess)
        result.getOrNull()?.playlist shouldBe playlist
    }

    @Test
    fun `getPlaylist - request - targets the playlist path and narrows fields`() = runTest {
        val content = Json.encodeToString(
            serializer = PlaylistObject.serializer(),
            value = playlistObject()
        )
        val engine = respondingWith(content = content)
        val dataSource = playlistRemoteDataSource(
            engine = engine,
            playlistOutputToDataMapper = FakePlaylistOutputToDataMapper(onMap = { playlistData(id = "playlist-7") })
        )

        dataSource.getPlaylist(params = GetPlaylistParams(id = PlaylistId(value = "playlist-7")))

        with(engine.requestHistory.first().url) {
            encodedPath shouldBe "/playlists/playlist-7"
            parameters["fields"] shouldBe "id,name,description,images"
        }
    }

    @Test
    fun `getPlaylist - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = playlistRemoteDataSource(engine = respondingWith(content = "[]"))

        val result = dataSource.getPlaylist(params = GetPlaylistParams(id = PlaylistId(value = "playlist-1")))

        assertTrue(result.isFailure)
    }

    @Test
    fun `getPlaylistTracks - successful response - returns result mapped via injected mapper`() = runTest {
        val expected = GetPlaylistTracksResult(
            tracks = listOf(playlistTrackData(id = "track-1")),
            total = 145
        )
        val content = Json.encodeToString(
            serializer = PagingPlaylistTrackObject.serializer(),
            value = pagingPlaylistTrackObject(items = listOf(playlistTrackObject()))
        )
        val dataSource = playlistRemoteDataSource(
            engine = respondingWith(content = content),
            playlistTracksResponseToResultMapper = FakePlaylistTracksResponseToResultMapper(onMap = { expected })
        )

        val result = dataSource.getPlaylistTracks(params = tracksParams())

        assertTrue(result.isSuccess)
        result.getOrNull() shouldBe expected
    }

    @Test
    fun `getPlaylistTracks - request - targets the items path with limit and offset`() = runTest {
        val content = Json.encodeToString(
            serializer = PagingPlaylistTrackObject.serializer(),
            value = pagingPlaylistTrackObject(items = emptyList())
        )
        val engine = respondingWith(content = content)
        val dataSource = playlistRemoteDataSource(
            engine = engine,
            playlistTracksResponseToResultMapper = FakePlaylistTracksResponseToResultMapper(
                onMap = { GetPlaylistTracksResult(tracks = emptyList(), total = 0) }
            )
        )

        dataSource.getPlaylistTracks(
            params = tracksParams(
                id = "playlist-9",
                limit = 7,
                offset = 14
            )
        )

        with(engine.requestHistory.first().url) {
            encodedPath shouldBe "/playlists/playlist-9/items"
            parameters["limit"] shouldBe "7"
            parameters["offset"] shouldBe "14"
        }
    }

    @Test
    fun `getPlaylistTracks - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = playlistRemoteDataSource(engine = respondingWith(content = "{}"))

        val result = dataSource.getPlaylistTracks(params = tracksParams())

        assertTrue(result.isFailure)
    }

    private fun tracksParams(
        id: String = "playlist-1",
        limit: Int = 50,
        offset: Int = 0
    ) = GetPlaylistTracksParams(
        id = PlaylistId(value = id),
        limit = limit,
        offset = offset
    )

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
            FakeSimplifiedPlaylistOutputToDataMapper(),
        playlistOutputToDataMapper: PlaylistOutputToDataMapper = FakePlaylistOutputToDataMapper(),
        playlistTracksResponseToResultMapper: PlaylistTracksResponseToResultMapper =
            FakePlaylistTracksResponseToResultMapper()
    ): PlaylistRemoteDataSourceImpl {
        val apiService = FakeApiService(onPlaylistsApi = { fakePlaylistsApi(engine = engine) })
        return PlaylistRemoteDataSourceImpl(
            apiService = apiService,
            simplifiedPlaylistOutputToDataMapper = simplifiedPlaylistOutputToDataMapper,
            playlistOutputToDataMapper = playlistOutputToDataMapper,
            playlistTracksResponseToResultMapper = playlistTracksResponseToResultMapper
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
