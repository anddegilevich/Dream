package and.degilevich.dream.shared.core.network.impl.configurator

import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.Serializable
import kotlin.test.Test

class ContentNegotiationConfiguratorImplTest {

    @Test
    fun `configure - json response - decodes the body into a serializable model`() = runTest {
        val client = HttpClient(
            engine = MockEngine {
                respond(
                    content = """{"name":"dream","count":3}""",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "application/json")
                )
            }
        ) {
            ContentNegotiationConfiguratorImpl().configure(config = this)
        }

        val body = client.get(URL).body<SampleBody>()

        body shouldBe SampleBody(name = "dream", count = 3)
    }

    @Serializable
    private data class SampleBody(
        val name: String,
        val count: Int
    )

    private companion object {
        const val URL = "https://api.test/endpoint"
    }
}
