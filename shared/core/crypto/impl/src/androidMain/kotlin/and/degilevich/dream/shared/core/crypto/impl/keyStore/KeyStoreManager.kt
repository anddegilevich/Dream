package and.degilevich.dream.shared.core.crypto.impl.keyStore

import javax.crypto.SecretKey

internal interface KeyStoreManager {
    fun getKey(): SecretKey
}