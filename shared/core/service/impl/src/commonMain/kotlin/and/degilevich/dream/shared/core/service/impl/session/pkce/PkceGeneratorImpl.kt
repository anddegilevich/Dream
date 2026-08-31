package and.degilevich.dream.shared.core.service.impl.session.pkce

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import and.degilevich.dream.shared.core.service.impl.session.model.PkceData
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
internal class PkceGeneratorImpl(
    private val secureBytesGenerator: SecureBytesGenerator,
    private val digestService: DigestService
) : PkceGenerator {

    override fun generate(): PkceData {
        val codeVerifier = generateRandomValue(size = VERIFIER_SIZE_BYTES)
        return PkceData(
            codeVerifier = codeVerifier,
            codeChallenge = encodeBase64Url(
                value = digestService.sha256(
                    value = codeVerifier.encodeToByteArray()
                )
            ),
            state = generateRandomValue(size = STATE_SIZE_BYTES)
        )
    }

    private fun generateRandomValue(size: Int): String {
        return encodeBase64Url(
            value = secureBytesGenerator.generate(size = size)
        )
    }

    private fun encodeBase64Url(value: ByteArray): String {
        return Base64.UrlSafe
            .withPadding(option = Base64.PaddingOption.ABSENT)
            .encode(source = value)
    }

    private companion object {
        const val VERIFIER_SIZE_BYTES = 64
        const val STATE_SIZE_BYTES = 32
    }
}
