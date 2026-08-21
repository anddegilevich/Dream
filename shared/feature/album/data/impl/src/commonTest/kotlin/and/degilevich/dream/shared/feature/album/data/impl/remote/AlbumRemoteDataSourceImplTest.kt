package and.degilevich.dream.shared.feature.album.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.core.service.test.api.fakeAlbumsApi
import and.degilevich.dream.shared.core.service.test.model.albumObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.test.remote.FakeAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.feature.album.model.core.api.method.getAlbum.GetAlbumParams
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

class AlbumRemoteDataSourceImplTest {

    @Test
    fun `getAlbum - successful response - returns mapped result via injected mapper`() = runTest {
        val albumData = AlbumData.empty()
        val content = Json.encodeToString(
            serializer = AlbumObject.serializer(),
            value = albumObject()
        )
        val dataSource = albumRemoteDataSource(
            engine = respondingWith(content = content),
            albumOutputToDataMapper = FakeAlbumOutputToDataMapper(onMap = { albumData })
        )
        val result = dataSource.getAlbum(
            params = GetAlbumParams(
                id = AlbumId(value = "album-id")
            )
        )
        assertTrue(result.isSuccess)
        result.getOrNull()?.album shouldBe albumData
    }

    @Test
    fun `getAlbum - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = albumRemoteDataSource(engine = respondingWith(content = "{}"))
        val result = dataSource.getAlbum(
            params = GetAlbumParams(
                id = AlbumId(value = "album-id")
            )
        )
        assertTrue(result.isFailure)
    }

    private fun albumRemoteDataSource(
        engine: MockEngine,
        albumOutputToDataMapper: AlbumOutputToDataMapper = FakeAlbumOutputToDataMapper()
    ): AlbumRemoteDataSourceImpl {
        val apiService = FakeApiService(onAlbumsApi = { fakeAlbumsApi(engine = engine) })
        return AlbumRemoteDataSourceImpl(apiService = apiService, albumOutputToDataMapper = albumOutputToDataMapper)
    }

    private fun respondingWith(content: String): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = HttpStatusCode.OK,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }
}
