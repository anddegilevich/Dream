package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.PlayerApi
import io.ktor.client.engine.mock.MockEngine

fun fakePlayerApi(engine: MockEngine): PlayerApi = PlayerApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
