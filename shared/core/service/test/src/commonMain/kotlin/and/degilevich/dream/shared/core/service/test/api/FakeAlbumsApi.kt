package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import io.ktor.client.engine.mock.MockEngine

fun fakeAlbumsApi(engine: MockEngine): AlbumsApi = AlbumsApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
