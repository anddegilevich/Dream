package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import io.ktor.client.engine.mock.MockEngine

fun fakeArtistsApi(engine: MockEngine): ArtistsApi = ArtistsApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
