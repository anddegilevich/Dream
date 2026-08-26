package and.degilevich.dream.shared.core.service.impl.session

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.session.model.AuthError
import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData
import and.degilevich.dream.shared.core.service.impl.session.model.pkceData
import and.degilevich.dream.shared.core.service.impl.session.pkce.FakePkceGenerator
import and.degilevich.dream.shared.core.service.impl.session.pkce.PkceGenerator
import and.degilevich.dream.shared.core.service.impl.session.redirect.AuthRedirectParser
import and.degilevich.dream.shared.core.service.impl.session.redirect.FakeAuthRedirectParser
import and.degilevich.dream.shared.core.service.impl.session.storage.FakeSessionStorage
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorage
import and.degilevich.dream.shared.core.service.impl.session.url.AuthUrlBuilder
import and.degilevich.dream.shared.core.service.impl.session.url.FakeAuthUrlBuilder
import and.degilevich.dream.shared.core.service.impl.session.webauth.FakeWebAuthLauncher
import and.degilevich.dream.shared.core.service.impl.token.client.FakeTokenService
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthError
import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class SessionServiceImplTest {

    @Test
    fun `login - always - opens the authorization url built from the generated pkce`() = runTest {
        val pkce = pkceData(state = "state-value")
        val authorizedUrls = mutableListOf<String>()
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkce }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { built -> "authorize?state=${built.state}" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.success(authRedirect(state = "state-value")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(
                onAuthorize = { url ->
                    authorizedUrls.add(url)
                    Result.success("and.degilevich.dream://callback")
                }
            ),
            tokenService = FakeTokenService(onExchangeCode = { _, _ -> Result.success(tokens()) }),
            sessionStorage = FakeSessionStorage(onSave = { })
        )

        sessionService.login()

        authorizedUrls.single() shouldBe "authorize?state=state-value"
    }

    @Test
    fun `login - redirect state matches - exchanges the code with the stored verifier`() = runTest {
        val pkce = pkceData(codeVerifier = "verifier-value", state = "state-value")
        val exchanges = mutableListOf<Pair<String, String>>()
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkce }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.success(authRedirect(code = "code-value", state = "state-value")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(onAuthorize = { Result.success("and.degilevich.dream://callback") }),
            tokenService = FakeTokenService(
                onExchangeCode = { code, codeVerifier ->
                    exchanges.add(code to codeVerifier)
                    Result.success(tokens())
                }
            ),
            sessionStorage = FakeSessionStorage(onSave = { })
        )

        sessionService.login()

        exchanges.single() shouldBe ("code-value" to "verifier-value")
    }

    @Test
    fun `login - exchange succeeds - stores the session and returns it`() = runTest {
        val savedSessions = mutableListOf<SessionData>()
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkceData(state = "state-value") }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.success(authRedirect(state = "state-value")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(onAuthorize = { Result.success("and.degilevich.dream://callback") }),
            tokenService = FakeTokenService(onExchangeCode = { _, _ -> Result.success(tokens()) }),
            sessionStorage = FakeSessionStorage(onSave = { session -> savedSessions.add(session) })
        )

        val result = sessionService.login()

        val expected = SessionData(tokens = tokens())
        savedSessions.single() shouldBe expected
        result.getOrNull() shouldBe expected
    }

    @Test
    fun `login - redirect state does not match - fails without exchanging or storing`() = runTest {
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkceData(state = "state-value") }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.success(authRedirect(state = "forged-state-value")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(onAuthorize = { Result.success("and.degilevich.dream://callback") })
        )

        val result = sessionService.login()

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.StateMismatch>()
    }

    @Test
    fun `login - user cancels the browser - propagates the cancellation`() = runTest {
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkceData() }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            webAuthLauncher = FakeWebAuthLauncher(
                onAuthorize = { Result.failure(WebAuthError.Cancelled()) }
            )
        )

        val result = sessionService.login()

        result.exceptionOrNull().shouldBeInstanceOf<WebAuthError.Cancelled>()
    }

    @Test
    fun `login - redirect cannot be parsed - fails without exchanging`() = runTest {
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkceData() }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.failure(AuthError.Denied(reason = "access_denied")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(onAuthorize = { Result.success("and.degilevich.dream://callback") })
        )

        val result = sessionService.login()

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.Denied>()
    }

    @Test
    fun `login - exchange fails - does not store a session`() = runTest {
        val sessionService = createSessionService(
            pkceGenerator = FakePkceGenerator(onGenerate = { pkceData(state = "state-value") }),
            authUrlBuilder = FakeAuthUrlBuilder(onBuild = { "authorize" }),
            authRedirectParser = FakeAuthRedirectParser(
                onParse = { Result.success(authRedirect(state = "state-value")) }
            ),
            webAuthLauncher = FakeWebAuthLauncher(onAuthorize = { Result.success("and.degilevich.dream://callback") }),
            tokenService = FakeTokenService(
                onExchangeCode = { _, _ -> Result.failure(IllegalStateException("exchange failed")) }
            )
        )

        val result = sessionService.login()

        result.isFailure shouldBe true
    }

    @Test
    fun `logout - always - clears the stored session`() = runTest {
        var sessionCleared = false
        val sessionService = createSessionService(
            sessionStorage = FakeSessionStorage(onClear = { sessionCleared = true })
        )

        sessionService.logout()

        sessionCleared shouldBe true
    }

    @Test
    fun `getActiveSession - stored session carries tokens - returns the stored session`() = runTest {
        val stored = SessionData(tokens = tokens())
        val sessionService = createSessionService(
            sessionStorage = FakeSessionStorage(onRead = { stored })
        )

        sessionService.getActiveSession().getOrNull() shouldBe stored
    }

    @Test
    fun `getActiveSession - nothing stored - fails`() = runTest {
        val sessionService = createSessionService(
            sessionStorage = FakeSessionStorage(onRead = { null })
        )

        val result = sessionService.getActiveSession()

        result.isFailure.shouldBe(true)
    }

    @Test
    fun `observeSession - storage emits a session - forwards it`() = runTest {
        val stored = SessionData(tokens = tokens())
        val sessionService = createSessionService(
            sessionStorage = FakeSessionStorage(onObserve = { flowOf(stored) })
        )

        sessionService.observeSession().test {
            awaitItem() shouldBe stored
            awaitComplete()
        }
    }

    @Suppress("LongParameterList")
    private fun createSessionService(
        pkceGenerator: PkceGenerator = FakePkceGenerator(),
        authUrlBuilder: AuthUrlBuilder = FakeAuthUrlBuilder(),
        authRedirectParser: AuthRedirectParser = FakeAuthRedirectParser(),
        webAuthLauncher: WebAuthLauncher = FakeWebAuthLauncher(),
        tokenService: TokenService = FakeTokenService(),
        sessionStorage: SessionStorage = FakeSessionStorage()
    ): SessionServiceImpl {
        return SessionServiceImpl(
            pkceGenerator = pkceGenerator,
            authUrlBuilder = authUrlBuilder,
            authRedirectParser = authRedirectParser,
            webAuthLauncher = webAuthLauncher,
            tokenService = tokenService,
            sessionStorage = sessionStorage
        )
    }

    private fun authRedirect(
        code: String = "code-value",
        state: String = "state-value"
    ): AuthRedirectData {
        return AuthRedirectData(
            code = code,
            state = state
        )
    }

    private fun tokens(): TokensData {
        return TokensData(
            accessToken = "access-token-value",
            refreshToken = "refresh-token-value",
            expirationTimestamp = 4_600_000L
        )
    }
}
