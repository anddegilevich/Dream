package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.impl.keystore.KeystoreManager
import and.degilevich.dream.shared.core.crypto.impl.keystore.SecretKeyConst
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec

internal actual class CryptoServiceImpl(
    private val keyStoreManager: KeystoreManager
) : CryptoService {

    override fun encrypt(value: ByteArray): Result<ByteArray> = runCatching {
        val cipher = getCipher()
        cipher.init(Cipher.ENCRYPT_MODE, keyStoreManager.getKey())
        val iv = cipher.iv
        val data = cipher.doFinal(value)
        iv + data
    }

    override fun decrypt(value: ByteArray): Result<ByteArray> = runCatching {
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