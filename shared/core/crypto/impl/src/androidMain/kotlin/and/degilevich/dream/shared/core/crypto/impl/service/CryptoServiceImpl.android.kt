package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.impl.keyStore.KeyStoreManager
import and.degilevich.dream.shared.core.crypto.impl.keyStore.SecretKeyConst
import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

internal actual class CryptoServiceImpl(
    private val keyStoreManager: KeyStoreManager
) : CryptoService {

    override fun encrypt(value: String): Result<String> {
        val bytes = value.toByteArray()
        return encryptBytes(bytes).foldResultSuccess { encryptedBytes ->
            Base64.getEncoder().encodeToString(encryptedBytes)
        }
    }

    override fun encryptOrNull(value: String): String? {
        return encrypt(value).getOrNull()
    }

    override fun decrypt(value: String): Result<String> {
        val bytes = Base64.getDecoder().decode(value)
        return decryptBytes(bytes).foldResultSuccess { decryptedBytes ->
            decryptedBytes.decodeToString()
        }
    }

    override fun decryptOrNull(value: String): String? {
        return decrypt(value).getOrNull()
    }

    private fun encryptBytes(value: ByteArray): Result<ByteArray> = runCatching {
        val cipher = getCipher()
        cipher.init(Cipher.ENCRYPT_MODE, keyStoreManager.getKey())
        val iv = cipher.iv
        val data = cipher.doFinal(value)
        iv + data
    }

    private fun decryptBytes(value: ByteArray): Result<ByteArray> = runCatching {
        val cipher = getCipher()
        val iv = value.copyOfRange(0, cipher.blockSize)
        val data = value.copyOfRange(cipher.blockSize, value.size)
        cipher.init(
            Cipher.DECRYPT_MODE,
            keyStoreManager.getKey(),
            IvParameterSpec(iv)
        )
        cipher.doFinal(data)
    }

    private fun getCipher(): Cipher {
        return Cipher.getInstance(SecretKeyConst.TRANSFORMATION)
    }
}