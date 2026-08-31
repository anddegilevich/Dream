package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import java.security.MessageDigest

internal actual class DigestServiceImpl : DigestService {

    override fun sha256(value: ByteArray): ByteArray {
        return MessageDigest.getInstance(ALGORITHM).digest(value)
    }

    private companion object {
        const val ALGORITHM = "SHA-256"
    }
}
