package and.degilevich.dream.shared.core.crypto.api.service

interface CryptoService {
    fun encrypt(value: String): Result<String>
    fun encryptOrNull(value: String): String?
    fun decrypt(value: String): Result<String>
    fun decryptOrNull(value: String): String?
}