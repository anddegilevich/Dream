package and.degilevich.dream.shared.core.crypto.api.service

interface CryptoService {
    fun encrypt(value: ByteArray): Result<ByteArray>
    fun decrypt(value: ByteArray): Result<ByteArray>
}