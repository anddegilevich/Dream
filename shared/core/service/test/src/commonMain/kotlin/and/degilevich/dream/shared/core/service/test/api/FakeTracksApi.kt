package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import io.ktor.client.engine.mock.MockEngine

fun fakeTracksApi(engine: MockEngine): TracksApi = TracksApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
