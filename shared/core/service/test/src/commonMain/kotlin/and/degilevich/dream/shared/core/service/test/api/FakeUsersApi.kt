package and.degilevich.dream.shared.core.service.test.api

import and.degilevich.dream.shared.core.service.api.generated.api.UsersApi
import io.ktor.client.engine.mock.MockEngine

fun fakeUsersApi(engine: MockEngine): UsersApi = UsersApi(
    baseUrl = "https://fake.api.com",
    httpClientEngine = engine
)
