package and.degilevich.dream.shared.core.crypto.impl.keychain

import and.degilevich.dream.shared.core.crypto.CryptoConst
import and.degilevich.dream.shared.core.crypto.impl.generator.RandomBytesGenerator
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDataCreate
import platform.CoreFoundation.CFDataGetBytePtr
import platform.CoreFoundation.CFDataGetLength
import platform.CoreFoundation.CFDataRef
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.CoreFoundation.CFDictionaryRef
import platform.CoreFoundation.CFTypeRefVar
import platform.CoreFoundation.kCFAllocatorDefault
import platform.CoreFoundation.kCFBooleanTrue
import platform.Security.SecItemAdd
import platform.Security.SecItemCopyMatching
import platform.Security.errSecDuplicateItem
import platform.Security.errSecSuccess
import platform.Security.kSecAttrAccessible
import platform.Security.kSecAttrAccessibleWhenUnlocked
import platform.Security.kSecAttrApplicationTag
import platform.Security.kSecClass
import platform.Security.kSecClassKey
import platform.Security.kSecMatchLimit
import platform.Security.kSecMatchLimitOne
import platform.Security.kSecReturnData
import platform.Security.kSecValueData
import platform.posix.memcpy

@OptIn(ExperimentalForeignApi::class)
internal class KeychainManagerImpl(
    private val randomBytesGenerator: RandomBytesGenerator
) : KeychainManager {

    private val tagData by lazy { CryptoConst.KEY_ALIAS.encodeToByteArray().let(::convertToCFData) }

    override fun getKey(): ByteArray {
        val key = loadKey()
        return if (key != null) {
            key
        } else {
            val newKey = randomBytesGenerator.generate(AES_KEY_SIZE_BYTES)
            saveKey(newKey)
            newKey
        }
    }

    private fun saveKey(key: ByteArray): Unit = memScoped {
        val keyData = key.let(::convertToCFData) ?: return
        val cfDictionary = getCfDictionary()
        cfDictionary.apply {
            CFDictionaryAddValue(this, kSecClass, kSecClassKey)
            CFDictionaryAddValue(this, kSecAttrApplicationTag, tagData)
            CFDictionaryAddValue(this, kSecAttrAccessible, kSecAttrAccessibleWhenUnlocked)
            CFDictionaryAddValue(this, kSecValueData, keyData)
        }
        val status = SecItemAdd(cfDictionary, null)
        check(status == errSecSuccess || status == errSecDuplicateItem) {
            "SecItemAdd failed with status: $status"
        }
    }

    private fun loadKey(): ByteArray? = memScoped {
        val cfDictionary = getCfDictionary()
        cfDictionary.apply {
            CFDictionaryAddValue(this, kSecClass, kSecClassKey)
            CFDictionaryAddValue(this, kSecAttrApplicationTag, tagData)
            CFDictionaryAddValue(this, kSecReturnData, kCFBooleanTrue)
            CFDictionaryAddValue(this, kSecMatchLimit, kSecMatchLimitOne)
        }
        val resultVar = alloc<CFTypeRefVar>()
        val status = SecItemCopyMatching(cfDictionary, resultVar.ptr)
        val cfTypeRef = resultVar.takeIf { status == errSecSuccess }?.value
        (cfTypeRef as? CFDataRef)?.let(::convertToByteArray)
    }

    private fun getCfDictionary(): CFDictionaryRef? = memScoped {
        return CFDictionaryCreateMutable(
            allocator = kCFAllocatorDefault,
            capacity = 0,
            keyCallBacks = null,
            valueCallBacks = null
        )
    }

    private fun convertToCFData(byteArray: ByteArray): CFDataRef? = memScoped {
        if (byteArray.isEmpty()) {
            CFDataCreate(kCFAllocatorDefault, null, 0)
        } else {
            byteArray.usePinned { pinned ->
                CFDataCreate(
                    kCFAllocatorDefault,
                    pinned.addressOf(0).reinterpret(),
                    byteArray.size.convert()
                )
            }
        }
    }

    private fun convertToByteArray(cfDataRef: CFDataRef): ByteArray {
        val len = CFDataGetLength(cfDataRef).toInt()
        if (len == 0) return ByteArray(0)

        val result = ByteArray(len)
        result.usePinned { pinned ->
            val src = CFDataGetBytePtr(cfDataRef)
            memcpy(pinned.addressOf(0), src, len.convert())
        }
        return result
    }

    private companion object {
        const val AES_KEY_SIZE_BYTES = 32
    }
}