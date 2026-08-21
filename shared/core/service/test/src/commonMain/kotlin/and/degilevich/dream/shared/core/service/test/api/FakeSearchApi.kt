package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import io.ktor.client.engine.mock.MockEngine

fun fakeSearchApi(engine: MockEngine): SearchApi = SearchApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
