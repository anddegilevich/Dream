package and.degilevich.dream.shared.core.service.impl.token.model.response

import io.kotest.matchers.shouldBe
import kotlinx.serialization.json.Json
import kotlin.test.Test

class TokenResponseTest {

    @Test
    fun `decode - payload rotates the refresh token - carries the rotated refresh token`() {
        val response = decode(
            payload = """
                {
                  "access_token": "granted-access-token",
                  "token_type": "Bearer",
                  "expires_in": 3600,
                  "scope": "user-read-private",
                  "refresh_token": "rotated-refresh-token"
                }
            """.trimIndent()
        )

        response.refreshToken shouldBe "rotated-refresh-token"
    }

    @Test
    fun `decode - payload omits the refresh token - decodes without a refresh token`() {
        val response = decode(
            payload = """
                {
                  "access_token": "granted-access-token",
                  "token_type": "Bearer",
                  "expires_in": 3600,
                  "scope": "user-read-private"
                }
            """.trimIndent()
        )

        response.refreshToken shouldBe null
    }

    @Test
    fun `decode - payload omits the refresh token - still carries the granted access token`() {
        val response = decode(
            payload = """{"access_token":"granted-access-token","token_type":"Bearer"}"""
        )

        response.accessToken shouldBe "granted-access-token"
    }

    private fun decode(payload: String): TokenResponse {
        return JSON.decodeFromString(
            deserializer = TokenResponse.serializer(),
            string = payload
        )
    }

    private companion object {
        val JSON = Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}
