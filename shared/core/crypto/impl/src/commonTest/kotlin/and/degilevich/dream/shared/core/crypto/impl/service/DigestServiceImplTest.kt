package and.degilevich.dream.shared.core.crypto.impl.service

import io.kotest.matchers.shouldBe
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.test.Test

@OptIn(ExperimentalEncodingApi::class)
class DigestServiceImplTest {

    @Test
    fun `sha256 - rfc7636 code verifier - base64url encodes to the published code challenge`() {
        val digest = DigestServiceImpl().sha256(RFC_7636_VERIFIER.encodeToByteArray())

        Base64.UrlSafe.withPadding(Base64.PaddingOption.ABSENT)
            .encode(digest) shouldBe RFC_7636_CHALLENGE
    }

    @Test
    fun `sha256 - known abc vector - returns the published digest`() {
        val digest = DigestServiceImpl().sha256("abc".encodeToByteArray())

        digest.toHex() shouldBe "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad"
    }

    @Test
    fun `sha256 - empty input - returns the published digest of the empty string`() {
        val digest = DigestServiceImpl().sha256(ByteArray(0))

        digest.toHex() shouldBe "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
    }

    @Test
    fun `sha256 - any input - returns 32 bytes`() {
        val digest = DigestServiceImpl().sha256(RFC_7636_VERIFIER.encodeToByteArray())

        digest.size shouldBe 32
    }

    @Test
    fun `sha256 - same input twice - returns the same digest`() {
        val service = DigestServiceImpl()

        service.sha256(RFC_7636_VERIFIER.encodeToByteArray())
            .toHex() shouldBe service.sha256(RFC_7636_VERIFIER.encodeToByteArray()).toHex()
    }

    private fun ByteArray.toHex(): String {
        return joinToString(separator = "") { byte ->
            byte.toInt().and(0xFF).toString(radix = 16).padStart(length = 2, padChar = '0')
        }
    }

    private companion object {
        const val RFC_7636_VERIFIER = "dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk"
        const val RFC_7636_CHALLENGE = "E9Melhoa2OwvFrEMTJguCHaoeK1t8URWbuGJSstw-cM"
    }
}
