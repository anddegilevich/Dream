package and.degilevich.dream.shared.feature.track.data.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.TrackObject
import and.degilevich.dream.shared.core.service.test.api.fakeTracksApi
import and.degilevich.dream.shared.core.service.test.model.trackObject
import and.degilevich.dream.shared.core.service.test.service.FakeApiService
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.test.remote.FakeTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.method.getTrack.GetTrackParams
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
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

    private fun createDataSource(
        engine: MockEngine,
        trackOutputToDataMapper: TrackOutputToDataMapper = FakeTrackOutputToDataMapper()
    ): TrackRemoteDataSourceImpl {
        val apiService = FakeApiService(onTracksApi = { fakeTracksApi(engine = engine) })
        return TrackRemoteDataSourceImpl(
            apiService = apiService,
            trackOutputToDataMapper = trackOutputToDataMapper
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
