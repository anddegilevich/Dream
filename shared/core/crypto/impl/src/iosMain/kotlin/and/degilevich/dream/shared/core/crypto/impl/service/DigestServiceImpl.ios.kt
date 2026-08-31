package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.UByteVar
import kotlinx.cinterop.allocArray
import kotlinx.cinterop.allocArrayOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.get
import kotlinx.cinterop.memScoped
import platform.CoreCrypto.CC_SHA256
import platform.CoreCrypto.CC_SHA256_DIGEST_LENGTH

@OptIn(ExperimentalForeignApi::class)
internal actual class DigestServiceImpl : DigestService {

    override fun sha256(value: ByteArray): ByteArray = memScoped {
        val digest = allocArray<UByteVar>(DIGEST_LENGTH)
        CC_SHA256(
            allocArrayOf(value),
            value.size.convert(),
            digest
        )
        ByteArray(DIGEST_LENGTH) { index ->
            digest[index].toByte()
        }
    }

    private companion object {
        const val DIGEST_LENGTH = CC_SHA256_DIGEST_LENGTH
    }
}
