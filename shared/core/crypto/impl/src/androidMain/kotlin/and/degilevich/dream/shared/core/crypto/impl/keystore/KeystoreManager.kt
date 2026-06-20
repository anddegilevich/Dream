package and.degilevich.dream.shared.core.crypto.impl.keystore

import javax.crypto.SecretKey

internal interface KeystoreManager {
    fun getKey(): SecretKey
}