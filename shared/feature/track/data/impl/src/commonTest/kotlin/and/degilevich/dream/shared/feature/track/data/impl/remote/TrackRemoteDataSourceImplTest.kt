package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSavedTrackObject
import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject
import and.degilevich.dream.shared.core.service.test.api.fakeTracksApi
import and.degilevich.dream.shared.core.service.test.model.pagingSavedTrackObject
import and.degilevich.dream.shared.core.service.test.model.savedTrackObject
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SavedTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeSavedTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksParams
import and.degilevich.dream.shared.feature.track.model.core.api.method.getSavedTracks.GetSavedTracksResult
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.test.data.savedTrackData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class TrackRemoteDataSourceImplTest {

    @Test
    fun `getTrack - successful response - returns mapped result via injected mapper`() = runTest {
        val trackData = trackData(id = "track-id")
        val content = Json.encodeToString(
            serializer = TrackObject.serializer(),
            value = trackObject()
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            trackOutputToDataMapper = FakeTrackOutputToDataMapper(onMap = { trackData })
        )
        val result = dataSource.getTrack(
            params = GetTrackParams(
                id = TrackId(value = "track-id")
            )
        )
        assertTrue(result.isSuccess)
        result.getOrNull()?.track shouldBe trackData
    }

    @Test
    fun `getTrack - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(engine = respondingWith(content = "not json"))
        val result = dataSource.getTrack(
            params = GetTrackParams(
                id = TrackId(value = "track-id")
            )
        )
        assertTrue(result.isFailure)
    }

    @Test
    fun `getSavedTracks - successful response - returns mapped result via injected mapper`() = runTest {
        val expected = GetSavedTracksResult(
            tracks = listOf(savedTrackData(id = "track-1")),
            total = 145
        )
        val content = Json.encodeToString(
            serializer = PagingSavedTrackObject.serializer(),
            value = pagingSavedTrackObject(
                items = listOf(savedTrackObject()),
                total = 145
            )
        )
        val dataSource = createDataSource(
            engine = respondingWith(content = content),
            savedTracksResponseToResultMapper = FakeSavedTracksResponseToResultMapper(onMap = { expected })
        )

        val result = dataSource.getSavedTracks(
            params = GetSavedTracksParams(limit = 20, offset = 40)
        )

        assertTrue(result.isSuccess)
        result.getOrNull() shouldBe expected
    }

    @Test
    fun `getSavedTracks - any params - sends limit and offset as query params`() = runTest {
        val requestedUrls = mutableListOf<Url>()
        val content = Json.encodeToString(
            serializer = PagingSavedTrackObject.serializer(),
            value = pagingSavedTrackObject()
        )
        val engine = MockEngine { request ->
            requestedUrls.add(request.url)
            respond(
                content = content,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val dataSource = createDataSource(
            engine = engine,
            savedTracksResponseToResultMapper = FakeSavedTracksResponseToResultMapper(
                onMap = { GetSavedTracksResult(tracks = emptyList(), total = 0) }
            )
        )

        dataSource.getSavedTracks(params = GetSavedTracksParams(limit = 20, offset = 40))

        with(requestedUrls.single()) {
            encodedPath shouldBe "/me/tracks"
            parameters["limit"] shouldBe "20"
            parameters["offset"] shouldBe "40"
        }
    }

    @Test
    fun `getSavedTracks - response body cannot be deserialized - returns failure`() = runTest {
        val dataSource = createDataSource(engine = respondingWith(content = "not json"))

        val result = dataSource.getSavedTracks(
            params = GetSavedTracksParams(limit = 20, offset = 0)
        )

        assertTrue(result.isFailure)
    }

    private fun createDataSource(
        engine: MockEngine,
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper(),
        savedTracksResponseToResultMapper: SavedTracksResponseToResultMapper = FakeSavedTracksResponseToResultMapper()
    ): TrackRemoteDataSourceImpl {
        val apiService = FakeApiService(onTracksApi = { fakeTracksApi(engine = engine) })
        return TrackRemoteDataSourceImpl(
            apiService = apiService,
            trackOutputToDataMapper = trackOutputToDataMapper,
            savedTracksResponseToResultMapper = savedTracksResponseToResultMapper
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
