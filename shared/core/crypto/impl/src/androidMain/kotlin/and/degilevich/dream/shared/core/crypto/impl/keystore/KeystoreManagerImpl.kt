package and.degilevich.dream.shared.core.crypto.impl.keystore

import and.degilevich.dream.shared.core.crypto.CryptoConst
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

internal class KeystoreManagerImpl : KeystoreManager {

    private val keyStore by lazy {
        KeyStore.getInstance(KEYSTORE_PROVIDER).apply { load(null) }
    }
    private val keyGenerator
        get() = KeyGenerator.getInstance(
            SecretKeyConst.ALGORITHM,
            KEYSTORE_PROVIDER
        )

    override fun getKey(): SecretKey {
        val keyEntry = keyStore.getEntry(CryptoConst.KEY_ALIAS, null) as? KeyStore.SecretKeyEntry
        return keyEntry?.secretKey ?: createKey()
    }

    private fun createKey(): SecretKey {
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            CryptoConst.KEY_ALIAS,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(SecretKeyConst.BLOCK_MODE)
            .setEncryptionPaddings(SecretKeyConst.PADDING)
            .setUserAuthenticationRequired(false)
            .setRandomizedEncryptionRequired(true)
            .build()

        return keyGenerator.apply {
            init(keyGenParameterSpec)
        }.generateKey()
    }

    private companion object {
        const val KEYSTORE_PROVIDER = "AndroidKeyStore"
    }
}