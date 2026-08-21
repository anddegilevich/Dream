package and.degilevich.dream.shared.feature.artist.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.PagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.core.service.test.api.fakeArtistsApi
import and.degilevich.dream.shared.core.service.test.model.artistObject
import and.degilevich.dream.shared.core.service.test.model.pagingArtistDiscographyAlbumObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.test.remote.FakeGetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtist.GetArtistParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsParams
import and.degilevich.dream.shared.feature.artist.model.core.api.method.getArtistAlbums.GetArtistAlbumsResult
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
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

class ArtistRemoteDataSourceImplTest {

    @Test
    fun `getArtist - successful response - returns mapped result via injected mapper`() = runTest {
        val artistData = artistData(id = "artist-id")
        val content = Json.encodeToString(
            serializer = ArtistObject.serializer(),
            value = artistObject()
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            artistOutputToDataMapper = FakeArtistOutputToDataMapper(onMap = { artistData })
        )
        val result = dataSource.getArtist(
            params = GetArtistParams(
                id = ArtistId(value = "artist-id")
            )
        )
        assertTrue(result.isSuccess)
        result.getOrNull()?.artist shouldBe artistData
    }

    @Test
    fun `getArtist - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(engine = respondingWith(content = "not json"))
        val result = dataSource.getArtist(
            params = GetArtistParams(
                id = ArtistId(value = "artist-id")
            )
        )
        assertTrue(result.isFailure)
    }

    @Test
    fun `getArtistAlbums - successful response - returns mapped result via injected mapper`() = runTest {
        val albumsResult = GetArtistAlbumsResult(
            total = 0,
            items = emptyList()
        )
        val content = Json.encodeToString(
            serializer = PagingArtistDiscographyAlbumObject.serializer(),
            value = pagingArtistDiscographyAlbumObject()
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            getArtistAlbumsResponseToResultMapper = FakeGetArtistAlbumsResponseToResultMapper(
                onMap = { albumsResult }
            )
        )
        val result = dataSource.getArtistAlbums(
            params = GetArtistAlbumsParams(
                id = ArtistId(value = "artist-id"),
                limit = 10,
                offset = 0
            )
        )
        assertTrue(result.isSuccess)
        result.getOrNull() shouldBe albumsResult
    }

    @Test
    fun `getArtistAlbums - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(engine = respondingWith(content = "{}"))
        val result = dataSource.getArtistAlbums(
            params = GetArtistAlbumsParams(
                id = ArtistId(value = "artist-id"),
                limit = 10,
                offset = 0
            )
        )
        assertTrue(result.isFailure)
    }

    private fun createDataSource(
        engine: MockEngine,
        artistOutputToDataMapper: ArtistOutputToDataMapper = FakeArtistOutputToDataMapper(),
        getArtistAlbumsResponseToResultMapper: GetArtistAlbumsResponseToResultMapper =
            FakeGetArtistAlbumsResponseToResultMapper()
    ): ArtistRemoteDataSourceImpl {
        val apiService = FakeApiService(onArtistsApi = { fakeArtistsApi(engine = engine) })
        return ArtistRemoteDataSourceImpl(
            apiService = apiService,
            artistOutputToDataMapper = artistOutputToDataMapper,
            getArtistAlbumsResponseToResultMapper = getArtistAlbumsResponseToResultMapper
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
