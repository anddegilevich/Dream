package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.api.model.TokensData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TokensDataToBearerMapperImplTest {

    @Test
    fun `map - always - carries both tokens into the bearer pair`() {
        val bearer = TokensDataToBearerMapperImpl().map(
            item = TokensData(
                accessToken = "access-token-value",
                refreshToken = "refresh-token-value"
            )
        )

        bearer.accessToken shouldBe "access-token-value"
        bearer.refreshToken shouldBe "refresh-token-value"
    }

    @Test
    fun `map - empty tokens - carries empty values rather than failing`() {
        val bearer = TokensDataToBearerMapperImpl().map(item = TokensData.empty())

        bearer.accessToken shouldBe ""
        bearer.refreshToken shouldBe ""
    }
}
