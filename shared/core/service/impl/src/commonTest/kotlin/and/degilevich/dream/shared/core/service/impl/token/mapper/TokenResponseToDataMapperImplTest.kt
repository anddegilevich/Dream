package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import and.degilevich.dream.shared.core.service.impl.token.model.response.tokenResponse
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TokenResponseToDataMapperImplTest {

    @Test
    fun `map - always - carries the granted access token`() {
        val tokens = TokenResponseToDataMapperImpl().map(
            item = tokenResponse(accessToken = "granted-access-token")
        )

        tokens.accessToken shouldBe "granted-access-token"
    }

    @Test
    fun `map - always - carries the granted refresh token`() {
        val tokens = TokenResponseToDataMapperImpl().map(
            item = tokenResponse(refreshToken = "granted-refresh-token")
        )

        tokens.refreshToken shouldBe "granted-refresh-token"
    }

    @Test
    fun `map - always - carries both tokens without altering them`() {
        val tokens = TokenResponseToDataMapperImpl().map(
            item = tokenResponse(
                accessToken = "granted-access-token",
                refreshToken = "granted-refresh-token"
            )
        )

        tokens shouldBe TokensData(
            accessToken = "granted-access-token",
            refreshToken = "granted-refresh-token"
        )
    }

    @Test
    fun `map - granted tokens are present - maps to a non-empty state`() {
        val tokens = TokenResponseToDataMapperImpl().map(item = tokenResponse())

        tokens.isEmpty() shouldBe false
    }
}
