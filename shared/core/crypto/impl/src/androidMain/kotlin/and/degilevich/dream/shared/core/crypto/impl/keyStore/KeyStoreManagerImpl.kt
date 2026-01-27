package and.degilevich.dream.shared.core.crypto.impl.keyStore

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import kotlin.getValue

internal class KeyStoreManagerImpl : KeyStoreManager {

    private val keyStore by lazy {
        KeyStore.getInstance(KEYSTORE_PROVIDER).apply { load(null) }
    }
    private val keyGenerator
        get() = KeyGenerator.getInstance(
            SecretKeyConst.ALGORITHM,
            KEYSTORE_PROVIDER
        )

    override fun getKey(): SecretKey {
        val keyEntry = keyStore.getEntry(KEY_ALIAS, null) as? KeyStore.SecretKeyEntry
        return keyEntry?.secretKey ?: createKey()
    }

    private fun createKey(): SecretKey {
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            KEY_ALIAS,
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
        const val KEY_ALIAS = "dream_key_alias"
    }
}