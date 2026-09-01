package and.degilevich.dream.shared.core.service.impl.session.url

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.service.impl.session.model.pkceData
import io.kotest.matchers.shouldBe
import io.ktor.http.Url
import kotlin.test.Test

class AuthUrlBuilderImplTest {

    @Test
    fun `build - always - targets the configured authorize endpoint`() {
        val url = Url(AuthUrlBuilderImpl().build(pkce = pkceData()))

        "${url.protocol.name}://${url.host}${url.encodedPath}" shouldBe SharedBuildConfig.AUTH_AUTHORIZE_URL
    }

    @Test
    fun `build - always - requests an authorization code with the S256 challenge method`() {
        val url = Url(AuthUrlBuilderImpl().build(pkce = pkceData()))

        url.parameters["response_type"] shouldBe "code"
        url.parameters["code_challenge_method"] shouldBe "S256"
    }

    @Test
    fun `build - always - carries the pkce challenge and state`() {
        val pkce = pkceData()

        val url = Url(AuthUrlBuilderImpl().build(pkce = pkce))

        url.parameters["code_challenge"] shouldBe pkce.codeChallenge
        url.parameters["state"] shouldBe pkce.state
    }

    @Test
    fun `build - always - never leaks the code verifier`() {
        val built = AuthUrlBuilderImpl().build(pkce = pkceData())

        built.contains(pkceData().codeVerifier) shouldBe false
    }

    @Test
    fun `build - always - carries the configured client id and redirect uri`() {
        val url = Url(AuthUrlBuilderImpl().build(pkce = pkceData()))

        url.parameters["client_id"] shouldBe SharedBuildConfig.CLIENT_ID
        url.parameters["redirect_uri"] shouldBe SharedBuildConfig.REDIRECT_URI
    }

    @Test
    fun `build - always - requests every supported scope`() {
        val url = Url(AuthUrlBuilderImpl().build(pkce = pkceData()))

        val scopes = url.parameters["scope"].orEmpty().split(" ")

        scopes shouldBe listOf(
            "ugc-image-upload",
            "user-read-playback-state",
            "user-modify-playback-state",
            "user-read-currently-playing",
            "app-remote-control",
            "streaming",
            "playlist-read-private",
            "playlist-read-collaborative",
            "playlist-modify-private",
            "playlist-modify-public",
            "user-follow-modify",
            "user-follow-read",
            "user-read-playback-position",
            "user-top-read",
            "user-read-recently-played",
            "user-library-modify",
            "user-library-read",
            "user-read-email",
            "user-read-private"
        )
    }
}
