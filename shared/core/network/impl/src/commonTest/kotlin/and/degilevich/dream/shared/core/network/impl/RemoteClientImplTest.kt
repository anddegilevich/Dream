package and.degilevich.dream.shared.core.network.impl

import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.network.impl.configurator.ContentNegotiationConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.FakeContentNegotiationConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.FakeLoggingConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.FakeTimeoutConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.LoggingConfigurator
import and.degilevich.dream.shared.core.network.impl.configurator.TimeoutConfigurator
import and.degilevich.dream.shared.core.network.impl.engine.FakeClientEngineFactory
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class RemoteClientImplTest {

    @Test
    fun `client - always - applies each configurator once in order`() {
        val applied = mutableListOf<String>()

        createRemoteClient(
            loggingConfigurator = FakeLoggingConfigurator(onConfigure = { applied.add("logging") }),
            contentNegotiationConfigurator = FakeContentNegotiationConfigurator(
                onConfigure = { applied.add("contentNegotiation") }
            ),
            timeoutConfigurator = FakeTimeoutConfigurator(onConfigure = { applied.add("timeout") })
        ).client

        applied shouldContainExactly listOf("logging", "contentNegotiation", "timeout")
    }

    @Test
    fun `client - error status - throws a response exception`() = runTest {
        val client = createRemoteClient(
            engine = MockEngine { respond(content = "", status = HttpStatusCode.NotFound) }
        ).client

        val error = shouldThrow<ResponseException> {
            client.get(URL)
        }

        error.response.status shouldBe HttpStatusCode.NotFound
    }

    private fun createRemoteClient(
        engine: MockEngine = MockEngine { respondOk() },
        loggingConfigurator: LoggingConfigurator = FakeLoggingConfigurator(onConfigure = {}),
        contentNegotiationConfigurator: ContentNegotiationConfigurator = FakeContentNegotiationConfigurator(
            onConfigure = {}
        ),
        timeoutConfigurator: TimeoutConfigurator = FakeTimeoutConfigurator(onConfigure = {})
    ): RemoteClient {
        return RemoteClientImpl(
            clientEngineFactory = FakeClientEngineFactory(onCreate = { engine }),
            loggingConfigurator = loggingConfigurator,
            contentNegotiationConfigurator = contentNegotiationConfigurator,
            timeoutConfigurator = timeoutConfigurator
        )
    }

    private companion object {
        const val URL = "https://api.test/endpoint"
    }
}
