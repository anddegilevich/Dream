package and.degilevich.dream.shared.core.service.impl.session.redirect

import and.degilevich.dream.shared.core.service.impl.session.model.AuthError
import and.degilevich.dream.shared.core.service.impl.session.model.AuthRedirectData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class AuthRedirectParserImplTest {

    @Test
    fun `parse - redirect carries a code and state - returns both`() {
        val result = AuthRedirectParserImpl().parse(
            url = "dream://auth/callback?code=code-value&state=state-value"
        )

        result.getOrNull() shouldBe AuthRedirectData(
            code = "code-value",
            state = "state-value"
        )
    }

    @Test
    fun `parse - redirect carries an encoded code - decodes it`() {
        val result = AuthRedirectParserImpl().parse(
            url = "dream://auth/callback?code=code%2Fwith%2Bchars&state=state-value"
        )

        result.getOrNull()?.code shouldBe "code/with+chars"
    }

    @Test
    fun `parse - user denied consent - fails with the reported reason`() {
        val result = AuthRedirectParserImpl().parse(
            url = "dream://auth/callback?error=access_denied&state=state-value"
        )

        val error = result.exceptionOrNull().shouldBeInstanceOf<AuthError.Denied>()
        error.reason shouldBe "access_denied"
    }

    @Test
    fun `parse - error takes precedence over a code - fails rather than continuing`() {
        val result = AuthRedirectParserImpl().parse(
            url = "dream://auth/callback?code=code-value&error=access_denied&state=state-value"
        )

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.Denied>()
    }

    @Test
    fun `parse - redirect carries no code - fails as malformed`() {
        val result = AuthRedirectParserImpl().parse(url = "dream://auth/callback?state=state-value")

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.Malformed>()
    }

    @Test
    fun `parse - redirect carries no state - fails as malformed`() {
        val result = AuthRedirectParserImpl().parse(url = "dream://auth/callback?code=code-value")

        result.exceptionOrNull().shouldBeInstanceOf<AuthError.Malformed>()
    }

    @Test
    fun `parse - url is not a url - fails rather than throwing`() {
        val result = AuthRedirectParserImpl().parse(url = "not a url at all")

        result.isFailure shouldBe true
    }
}
