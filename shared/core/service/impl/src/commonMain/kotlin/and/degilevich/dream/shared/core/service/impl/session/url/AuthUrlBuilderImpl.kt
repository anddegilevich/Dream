package and.degilevich.dream.shared.core.service.impl.session.url

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import and.degilevich.dream.shared.core.service.impl.session.model.SpotifyScope
import io.ktor.http.URLBuilder

internal class AuthUrlBuilderImpl : AuthUrlBuilder {

    override fun build(pkce: PkceData): String {
        return URLBuilder(SharedBuildConfig.AUTH_AUTHORIZE_URL).apply {
            parameters.apply {
                append(PARAM_CLIENT_ID, SharedBuildConfig.CLIENT_ID)
                append(PARAM_RESPONSE_TYPE, RESPONSE_TYPE_CODE)
                append(PARAM_REDIRECT_URI, SharedBuildConfig.REDIRECT_URI)
                append(PARAM_SCOPE, SCOPES.joinToString(separator = SCOPE_SEPARATOR) { scope -> scope.value })
                append(PARAM_CODE_CHALLENGE_METHOD, CODE_CHALLENGE_METHOD_S256)
                append(PARAM_CODE_CHALLENGE, pkce.codeChallenge)
                append(PARAM_STATE, pkce.state)
            }
        }.buildString()
    }

    private companion object {
        const val PARAM_CLIENT_ID = "client_id"
        const val PARAM_RESPONSE_TYPE = "response_type"
        const val PARAM_REDIRECT_URI = "redirect_uri"
        const val PARAM_SCOPE = "scope"
        const val PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method"
        const val PARAM_CODE_CHALLENGE = "code_challenge"
        const val PARAM_STATE = "state"
        const val RESPONSE_TYPE_CODE = "code"
        const val CODE_CHALLENGE_METHOD_S256 = "S256"
        const val SCOPE_SEPARATOR = " "
        val SCOPES = listOf(
            SpotifyScope.UGC_IMAGE_UPLOAD,
            SpotifyScope.USER_READ_PLAYBACK_STATE,
            SpotifyScope.USER_MODIFY_PLAYBACK_STATE,
            SpotifyScope.USER_READ_CURRENTLY_PLAYING,
            SpotifyScope.APP_REMOTE_CONTROL,
            SpotifyScope.STREAMING,
            SpotifyScope.PLAYLIST_READ_PRIVATE,
            SpotifyScope.PLAYLIST_READ_COLLABORATIVE,
            SpotifyScope.PLAYLIST_MODIFY_PRIVATE,
            SpotifyScope.PLAYLIST_MODIFY_PUBLIC,
            SpotifyScope.USER_FOLLOW_MODIFY,
            SpotifyScope.USER_FOLLOW_READ,
            SpotifyScope.USER_READ_PLAYBACK_POSITION,
            SpotifyScope.USER_TOP_READ,
            SpotifyScope.USER_READ_RECENTLY_PLAYED,
            SpotifyScope.USER_LIBRARY_MODIFY,
            SpotifyScope.USER_LIBRARY_READ,
            SpotifyScope.USER_READ_EMAIL,
            SpotifyScope.USER_READ_PRIVATE
        )
    }
}
