package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService

// TODO: Implement proper encryption
internal actual class CryptoServiceImpl : CryptoService {

    override fun encrypt(value: String): Result<String> {
        return Result.failure(Exception("Not yet implemented"))
    }

    override fun encryptOrNull(value: String): String? {
        return null
    }

    override fun decrypt(value: String): Result<String> {
        return Result.failure(Exception("Not yet implemented"))
    }

    override fun decryptOrNull(value: String): String? {
        return null
    }
}