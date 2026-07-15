package and.degilevich.dream.shared.core.crypto.impl.keychain

internal interface KeychainManager {
    fun getKey(): ByteArray
}