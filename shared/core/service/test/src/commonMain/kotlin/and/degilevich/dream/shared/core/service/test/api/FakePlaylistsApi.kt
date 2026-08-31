package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.PlaylistsApi
import io.ktor.client.engine.mock.MockEngine

fun fakePlaylistsApi(engine: MockEngine): PlaylistsApi = PlaylistsApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
