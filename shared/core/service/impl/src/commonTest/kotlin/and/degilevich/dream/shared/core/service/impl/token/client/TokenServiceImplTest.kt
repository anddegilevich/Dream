package and.degilevich.dream.shared.core.service.impl.token.client

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.network.fakeRemoteClient
import and.degilevich.dream.shared.core.service.impl.session.model.AuthError
import and.degilevich.dream.shared.core.service.impl.token.mapper.FakeTokenResponseToDataMapper
import and.degilevich.dream.shared.core.service.impl.token.mapper.TokenResponseToDataMapper
import and.degilevich.dream.shared.core.service.impl.token.mapper.TokenResponseToDataMapperImpl
import and.degilevich.dream.shared.core.service.impl.token.model.response.TokenResponse
import and.degilevich.dream.shared.core.service.impl.token.model.response.tokenResponse
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
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
            tokenResponseToDataMapper = mapperReturning(tokens = tokensData())
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
            tokenResponseToDataMapper = mapperReturning(tokens = tokensData())
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
            tokenResponseToDataMapper = mapperReturning(tokens = tokensData())
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
            tokenResponseToDataMapper = FakeTokenResponseToDataMapper(
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
            tokenResponseToDataMapper = mapperReturning(tokens = tokensData())
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
            tokenResponseToDataMapper = mapperReturning(
                tokens = tokensData(refreshToken = "rotated-refresh-token")
            )
        )

        val result = tokenService.refresh(refreshToken = "current-refresh-token")

        result.getOrNull()?.refreshToken shouldBe "rotated-refresh-token"
    }

    @Test
    fun `refresh - response omits the refresh token - keeps the current refresh token`() = runTest {
        val tokenService = createTokenService(
            engine = respondingWith(content = REFRESH_PAYLOAD_WITHOUT_REFRESH_TOKEN),
            tokenResponseToDataMapper = TokenResponseToDataMapperImpl()
        )

        val result = tokenService.refresh(refreshToken = "current-refresh-token")

        result.getOrNull()?.refreshToken shouldBe "current-refresh-token"
    }

    @Test
    fun `refresh - response omits the refresh token - still returns the granted access token`() = runTest {
        val tokenService = createTokenService(
            engine = respondingWith(content = REFRESH_PAYLOAD_WITHOUT_REFRESH_TOKEN),
            tokenResponseToDataMapper = TokenResponseToDataMapperImpl()
        )

        val result = tokenService.refresh(refreshToken = "current-refresh-token")

        result.getOrNull()?.accessToken shouldBe "refreshed-access-token"
    }

    @Test
    fun `refresh - response rotates the refresh token - returns the rotated refresh token`() = runTest {
        val tokenService = createTokenService(
            engine = respondingWith(content = REFRESH_PAYLOAD_WITH_ROTATED_REFRESH_TOKEN),
            tokenResponseToDataMapper = TokenResponseToDataMapperImpl()
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

    @Test
    fun `refresh - token endpoint rejects the grant - fails with a grant rejected error`() = runTest {
        val engine = respondingWith(
            content = """{"error":"invalid_grant"}""",
            status = HttpStatusCode.BadRequest
        )

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.GrantRejected>()
    }

    @Test
    fun `refresh - token endpoint answers unauthorized - fails with a grant rejected error`() = runTest {
        val engine = respondingWith(
            content = """{"error":"invalid_client"}""",
            status = HttpStatusCode.Unauthorized
        )

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.GrantRejected>()
    }

    @Test
    fun `refresh - token endpoint rate limits - fails without rejecting the grant`() = runTest {
        val engine = respondingWith(
            content = """{"error":"too_many_requests"}""",
            status = HttpStatusCode.TooManyRequests
        )

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        result.isFailure shouldBe true
        (result.exceptionOrNull() is AuthError.GrantRejected) shouldBe false
    }

    @Test
    fun `refresh - token endpoint fails server side - fails without rejecting the grant`() = runTest {
        val engine = respondingWith(
            content = "",
            status = HttpStatusCode.ServiceUnavailable
        )

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        result.isFailure shouldBe true
        (result.exceptionOrNull() is AuthError.GrantRejected) shouldBe false
    }

    @Test
    fun `refresh - token endpoint is unreachable - fails without rejecting the grant`() = runTest {
        val engine = MockEngine { throw IllegalStateException("network is down") }

        val result = createTokenService(engine = engine).refresh(refreshToken = "current-refresh-token")

        result.isFailure shouldBe true
        (result.exceptionOrNull() is AuthError.GrantRejected) shouldBe false
    }

    @Test
    fun `exchangeCode - token endpoint rejects the grant - fails with a grant rejected error`() = runTest {
        val engine = respondingWith(
            content = """{"error":"invalid_grant"}""",
            status = HttpStatusCode.BadRequest
        )

        val result = createTokenService(engine = engine).exchangeCode(
            code = "code-value",
            codeVerifier = "verifier-value"
        )

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.GrantRejected>()
    }

    private fun createTokenService(
        engine: MockEngine,
        tokenResponseToDataMapper: TokenResponseToDataMapper = FakeTokenResponseToDataMapper()
    ): TokenServiceImpl {
        return TokenServiceImpl(
            remoteClient = fakeRemoteClient(engine = engine),
            tokenResponseToDataMapper = tokenResponseToDataMapper
        )
    }

    private fun mapperReturning(tokens: TokensData): TokenResponseToDataMapper {
        return FakeTokenResponseToDataMapper(onMap = { tokens })
    }

    private fun tokensData(
        accessToken: String = "mapped-access-token",
        refreshToken: String = "mapped-refresh-token"
    ): TokensData {
        return TokensData(
            accessToken = accessToken,
            refreshToken = refreshToken
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

    private companion object {
        const val REFRESH_PAYLOAD_WITHOUT_REFRESH_TOKEN =
            """{"access_token":"refreshed-access-token","token_type":"Bearer","expires_in":3600}"""
        const val REFRESH_PAYLOAD_WITH_ROTATED_REFRESH_TOKEN =
            """{"access_token":"refreshed-access-token","refresh_token":"rotated-refresh-token"}"""
    }
}
