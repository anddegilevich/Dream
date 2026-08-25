package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.network.fakeRemoteClient
import and.degilevich.dream.shared.core.service.impl.token.mapper.FakeTokensOutputToDataMapper
import and.degilevich.dream.shared.core.service.impl.token.mapper.TokensOutputToDataMapper
import and.degilevich.dream.shared.core.service.impl.token.model.request.TokenResponse
import and.degilevich.dream.shared.core.service.impl.token.model.request.tokenResponse
import io.kotest.matchers.shouldBe
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.Parameters
import io.ktor.http.Url
import io.ktor.http.content.OutgoingContent
import io.ktor.http.headersOf
import io.ktor.http.parseQueryString
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertTrue

class TokenServiceImplTest {

    @Test
    fun `exchangeCode - always - targets the configured token endpoint`() = runTest {
        val engine = respondingWith(content = encoded(response = tokenResponse()))

        createTokenService(
            engine = engine,
            tokensOutputToDataMapper = mapperReturning(tokens = tokensData())
        ).exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        val url = Url(engine.requestHistory.last().url.toString())
        "${url.protocol.name}://${url.host}${url.encodedPath}" shouldBe SharedBuildConfig.AUTH_TOKEN_URL
    }

    @Test
    fun `exchangeCode - always - posts the authorization code grant as a form body`() = runTest {
        val engine = respondingWith(content = encoded(response = tokenResponse()))

        createTokenService(
            engine = engine,
            tokensOutputToDataMapper = mapperReturning(tokens = tokensData())
        ).exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        val parameters = engine.lastFormParameters()
        parameters["grant_type"] shouldBe "authorization_code"
        parameters["code"] shouldBe "code-value"
        parameters["code_verifier"] shouldBe "verifier-value"
        parameters["client_id"] shouldBe SharedBuildConfig.CLIENT_ID
        parameters["redirect_uri"] shouldBe SharedBuildConfig.REDIRECT_URI
    }

    @Test
    fun `exchangeCode - always - never sends a client secret`() = runTest {
        val engine = respondingWith(content = encoded(response = tokenResponse()))

        createTokenService(
            engine = engine,
            tokensOutputToDataMapper = mapperReturning(tokens = tokensData())
        ).exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        engine.requestHistory.last().url.toString().contains("client_secret") shouldBe false
        engine.lastFormParameters()["client_secret"] shouldBe null
    }

    @Test
    fun `exchangeCode - successful response - returns the mapped response body`() = runTest {
        val response = tokenResponse(accessToken = "granted-access-token")
        val mapped = tokensData(accessToken = "mapped-access-token")
        val mappedResponses = mutableListOf<TokenResponse>()
        val tokenService = createTokenService(
            engine = respondingWith(content = encoded(response = response)),
            tokensOutputToDataMapper = FakeTokensOutputToDataMapper(
                onMap = { item ->
                    mappedResponses.add(item)
                    mapped
                }
            )
        )

        val result = tokenService.exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        mappedResponses.single() shouldBe response
        result.getOrNull() shouldBe mapped
    }

    @Test
    fun `exchangeCode - error response - returns failure without mapping`() = runTest {
        val engine = respondingWith(
            content = """{"error":"invalid_grant"}""",
            status = HttpStatusCode.BadRequest
        )

        val result = createTokenService(engine = engine).exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        assertTrue(result.isFailure)
    }

    @Test
    fun `refresh - always - posts the refresh token grant as a form body`() = runTest {
        val engine = respondingWith(content = encoded(response = tokenResponse()))

        createTokenService(
            engine = engine,
            tokensOutputToDataMapper = mapperReturning(tokens = tokensData())
        ).refresh(refreshToken = "current-refresh-token")

        val parameters = engine.lastFormParameters()
        parameters["grant_type"] shouldBe "refresh_token"
        parameters["refresh_token"] shouldBe "current-refresh-token"
        parameters["client_id"] shouldBe SharedBuildConfig.CLIENT_ID
    }

    @Test
    fun `refresh - always - returns the refresh token exactly as mapped`() = runTest {
        val tokenService = createTokenService(
            engine = respondingWith(content = encoded(response = tokenResponse())),
            tokensOutputToDataMapper = mapperReturning(
                tokens = tokensData(refreshToken = "rotated-refresh-token")
            )
        )

        val result = tokenService.refresh(refreshToken = "current-refresh-token")

        result.getOrNull()?.refreshToken shouldBe "rotated-refresh-token"
    }

    @Test
    fun `refresh - error response - returns failure without mapping`() = runTest {
        val engine = respondingWith(
            content = """{"error":"invalid_grant"}""",
            status = HttpStatusCode.BadRequest
        )

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        assertTrue(result.isFailure)
    }

    private fun createTokenService(
        engine: MockEngine,
        tokensOutputToDataMapper: TokensOutputToDataMapper = FakeTokensOutputToDataMapper()
    ): TokenServiceImpl {
        return TokenServiceImpl(
            remoteClient = fakeRemoteClient(engine = engine),
            tokensOutputToDataMapper = tokensOutputToDataMapper
        )
    }

    private fun mapperReturning(tokens: TokensData): TokensOutputToDataMapper {
        return FakeTokensOutputToDataMapper(onMap = { tokens })
    }

    private fun tokensData(
        accessToken: String = "mapped-access-token",
        refreshToken: String = "mapped-refresh-token",
        expirationTimestamp: Long = 4_600_000L
    ): TokensData {
        return TokensData(
            accessToken = accessToken,
            refreshToken = refreshToken,
            expirationTimestamp = expirationTimestamp
        )
    }

    private fun respondingWith(
        content: String,
        status: HttpStatusCode = HttpStatusCode.OK
    ): MockEngine = MockEngine { _ ->
        respond(
            content = content,
            status = status,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )
    }

    private fun encoded(response: TokenResponse): String {
        return Json.encodeToString(
            serializer = TokenResponse.serializer(),
            value = response
        )
    }

    private fun MockEngine.lastFormParameters(): Parameters {
        val body = requestHistory.last().body as OutgoingContent.ByteArrayContent
        return parseQueryString(body.bytes().decodeToString())
    }
}
