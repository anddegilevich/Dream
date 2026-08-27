package and.degilevich.dream.shared.core.service.impl.session

import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.api.session.SessionService
import and.degilevich.dream.shared.core.service.impl.session.model.AuthError
import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData
import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import and.degilevich.dream.shared.core.service.impl.session.pkce.PkceGenerator
import and.degilevich.dream.shared.core.service.impl.session.redirect.AuthRedirectParser
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorage
import and.degilevich.dream.shared.core.service.impl.session.url.AuthUrlBuilder
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import kotlinx.coroutines.flow.Flow

internal class SessionServiceImpl(
    private val pkceGenerator: PkceGenerator,
    private val authUrlBuilder: AuthUrlBuilder,
    private val authRedirectParser: AuthRedirectParser,
    private val webAuthLauncher: WebAuthLauncher,
    private val tokenService: TokenService,
    private val sessionStorage: SessionStorage
) : SessionService {

    override suspend fun login(): Result<SessionData> {
        val pkce = pkceGenerator.generate()
        val authUrl = authUrlBuilder.build(pkce = pkce)
        return webAuthLauncher.authorize(url = authUrl)
            .mapCatching { redirectUrl ->
                authRedirectParser.parse(url = redirectUrl).getOrThrow()
            }
            .mapCatching { redirect ->
                exchangeCode(
                    redirect = redirect,
                    pkce = pkce
                ).getOrThrow()
            }
            .onSuccess { session ->
                sessionStorage.save(value = session)
            }
    }

    override suspend fun logout() {
        sessionStorage.clear()
    }

    override suspend fun getActiveSession(): Result<SessionData> {
        return runCatching { sessionStorage.read()!! }
    }

    override fun observeSession(): Flow<SessionData?> {
        return sessionStorage.observe()
    }

    private suspend fun exchangeCode(
        redirect: AuthRedirectData,
        pkce: PkceData
    ): Result<SessionData> {
        return if (redirect.state == pkce.state) {
            tokenService.exchangeCode(
                code = redirect.code,
                codeVerifier = pkce.codeVerifier
            ).map { tokens ->
                SessionData(tokens = tokens)
            }
        } else {
            Result.failure(AuthError.StateMismatch())
        }
    }
}
