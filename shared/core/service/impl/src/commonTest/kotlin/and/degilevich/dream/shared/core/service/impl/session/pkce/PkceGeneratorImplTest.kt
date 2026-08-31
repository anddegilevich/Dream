package and.degilevich.dream.shared.core.service.impl.session.pkce

import and.degilevich.dream.shared.core.crypto.test.generator.FakeSecureBytesGenerator
import and.degilevich.dream.shared.core.crypto.test.service.FakeDigestService
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class PkceGeneratorImplTest {

    @Test
    fun `generate - always - encodes the verifier as unpadded base64url of 64 random bytes`() {
        val generator = PkceGeneratorImpl(
            secureBytesGenerator = FakeSecureBytesGenerator(onGenerate = { size -> ByteArray(size) }),
            digestService = FakeDigestService(onSha256 = { ByteArray(32) })
        )

        val pkce = generator.generate()

        pkce.codeVerifier shouldBe "A".repeat(86)
    }

    @Test
    fun `generate - always - produces a verifier within the RFC 7636 length bounds`() {
        val generator = PkceGeneratorImpl(
            secureBytesGenerator = FakeSecureBytesGenerator(onGenerate = { size -> ByteArray(size) { 1 } }),
            digestService = FakeDigestService(onSha256 = { ByteArray(32) })
        )

        val length = generator.generate().codeVerifier.length

        (length in 43..128) shouldBe true
    }

    @Test
    fun `generate - always - challenge is unpadded base64url of the sha256 of the verifier ascii bytes`() {
        var hashed: ByteArray? = null
        val generator = PkceGeneratorImpl(
            secureBytesGenerator = FakeSecureBytesGenerator(onGenerate = { size -> ByteArray(size) }),
            digestService = FakeDigestService(
                onSha256 = { value ->
                    hashed = value
                    ByteArray(32)
                }
            )
        )

        val pkce = generator.generate()

        hashed?.decodeToString() shouldBe pkce.codeVerifier
        pkce.codeChallenge shouldBe "A".repeat(43)
    }

    @Test
    fun `generate - always - never emits base64 padding or url unsafe characters`() {
        val generator = PkceGeneratorImpl(
            secureBytesGenerator = FakeSecureBytesGenerator(
                onGenerate = { size -> ByteArray(size) { index -> index.toByte() } }
            ),
            digestService = FakeDigestService(onSha256 = { ByteArray(32) { index -> index.toByte() } })
        )

        val pkce = generator.generate()

        listOf(pkce.codeVerifier, pkce.codeChallenge, pkce.state).forEach { value ->
            value.contains('=') shouldBe false
            value.contains('+') shouldBe false
            value.contains('/') shouldBe false
        }
    }

    @Test
    fun `generate - always - draws the state from separate random bytes than the verifier`() {
        val sizes = mutableListOf<Int>()
        val generator = PkceGeneratorImpl(
            secureBytesGenerator = FakeSecureBytesGenerator(
                onGenerate = { size ->
                    sizes.add(size)
                    ByteArray(size) { sizes.size.toByte() }
                }
            ),
            digestService = FakeDigestService(onSha256 = { ByteArray(32) })
        )

        val pkce = generator.generate()

        sizes.size shouldBe 2
        pkce.state shouldNotBe pkce.codeVerifier
    }
}
