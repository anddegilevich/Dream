package and.degilevich.dream.shared.core.service.impl.token.mapper

import and.degilevich.dream.shared.core.service.impl.datetime.FakeCurrentDateTime
import and.degilevich.dream.shared.core.service.impl.datetime.FakeDateTime
import and.degilevich.dream.shared.core.service.impl.token.model.request.tokenResponse
import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TokensOutputToDataMapperImplTest {

    @Test
    fun `map - always - carries the granted access token`() {
        val tokens = createMapper().map(
            item = tokenResponse(accessToken = "granted-access-token")
        )

        tokens.accessToken shouldBe "granted-access-token"
    }

    @Test
    fun `map - response omits the access token - maps it to empty`() {
        val tokens = createMapper().map(item = tokenResponse(accessToken = null))

        tokens.accessToken shouldBe ""
    }

    @Test
    fun `map - always - carries the granted refresh token`() {
        val tokens = createMapper().map(
            item = tokenResponse(refreshToken = "granted-refresh-token")
        )

        tokens.refreshToken shouldBe "granted-refresh-token"
    }

    @Test
    fun `map - response omits the refresh token - maps it to empty`() {
        val tokens = createMapper().map(item = tokenResponse(refreshToken = null))

        tokens.refreshToken shouldBe ""
    }

    @Test
    fun `map - always - turns the relative lifetime into an absolute expiration`() {
        val tokens = createMapper(currentTimeMillis = 1_000_000L).map(
            item = tokenResponse(expiresIn = 3600)
        )

        tokens.expirationTimestamp shouldBe 4_600_000L
    }

    @Test
    fun `map - response omits the lifetime - expires immediately`() {
        val tokens = createMapper(currentTimeMillis = 1_000_000L).map(
            item = tokenResponse(expiresIn = null)
        )

        tokens.expirationTimestamp shouldBe 1_000_000L
    }

    private fun createMapper(currentTimeMillis: Long = 0L): TokensOutputToDataMapperImpl {
        return TokensOutputToDataMapperImpl(dateTime = dateTimeAt(currentTimeMillis = currentTimeMillis))
    }

    private fun dateTimeAt(currentTimeMillis: Long): DateTime {
        return FakeDateTime(
            current = FakeCurrentDateTime(onCurrentTimeMillis = { currentTimeMillis })
        )
    }
}
