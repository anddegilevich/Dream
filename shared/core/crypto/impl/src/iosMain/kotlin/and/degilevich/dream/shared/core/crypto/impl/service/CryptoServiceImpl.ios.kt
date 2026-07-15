package and.degilevich.dream.shared.core.crypto.impl.service

import and.degilevich.dream.shared.core.crypto.api.service.CryptoService
import and.degilevich.dream.shared.core.crypto.impl.generator.RandomBytesGenerator
import and.degilevich.dream.shared.core.crypto.impl.keychain.KeychainManager
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import platform.CoreCrypto.CCCrypt
import platform.CoreCrypto.kCCAlgorithmAES
import platform.CoreCrypto.kCCBlockSizeAES128
import platform.CoreCrypto.kCCDecrypt
import platform.CoreCrypto.kCCEncrypt
import platform.CoreCrypto.kCCOptionPKCS7Padding
import platform.CoreCrypto.kCCSuccess
import platform.posix.size_tVar

@OptIn(ExperimentalForeignApi::class)
internal actual class CryptoServiceImpl(
    private val keyChainManager: KeychainManager,
    private val randomBytesGenerator: RandomBytesGenerator
) : CryptoService {

    override fun encrypt(value: ByteArray): Result<ByteArray> = runCatching {
        val key = keyChainManager.getKey()
        val iv = randomBytesGenerator.generate(AES_BLOCK_SIZE)
        val outBuffer = ByteArray(value.size + AES_BLOCK_SIZE)
        var outLength = 0
        memScoped {
            val outLengthVar = alloc<size_tVar>()
            val status = key.usePinned { keyPinned ->
                iv.usePinned { ivPinned ->
                    value.usePinned { inPinned ->
                        outBuffer.usePinned { outPinned ->
                            CCCrypt(
                                op = kCCEncrypt,
                                alg = kCCAlgorithmAES,
                                options = kCCOptionPKCS7Padding,
                                key = keyPinned.addressOf(0),
                                keyLength = key.size.convert(),
                                iv = ivPinned.addressOf(0),
                                dataIn = inPinned.addressOf(0),
                                dataInLength = value.size.convert(),
                                dataOut = outPinned.addressOf(0),
                                dataOutAvailable = outBuffer.size.convert(),
                                dataOutMoved = outLengthVar.ptr
                            )
                        }
                    }
                }
            }

            if (status != kCCSuccess) {
                return@runCatching value
            }
            outLength = outLengthVar.value.toInt()
        }
        val cipher = outBuffer.copyOf(outLength)
        iv + cipher
    }

    override fun decrypt(value: ByteArray): Result<ByteArray> = runCatching {
        if (value.size <= AES_BLOCK_SIZE) return@runCatching value
        val key = keyChainManager.getKey()
        val iv = value.copyOfRange(0, AES_BLOCK_SIZE)
        val cipher = value.copyOfRange(AES_BLOCK_SIZE, value.size)
        val outBuffer = ByteArray(cipher.size + AES_BLOCK_SIZE)
        var outLength = 0
        memScoped {
            val outLengthVar = alloc<size_tVar>()
            val status = key.usePinned { keyPinned ->
                iv.usePinned { ivPinned ->
                    cipher.usePinned { inPinned ->
                        outBuffer.usePinned { outPinned ->
                            CCCrypt(
                                op = kCCDecrypt,
                                alg = kCCAlgorithmAES,
                                options = kCCOptionPKCS7Padding,
                                key = keyPinned.addressOf(0),
                                keyLength = key.size.convert(),
                                iv = ivPinned.addressOf(0),
                                dataIn = inPinned.addressOf(0),
                                dataInLength = cipher.size.convert(),
                                dataOut = outPinned.addressOf(0),
                                dataOutAvailable = outBuffer.size.convert(),
                                dataOutMoved = outLengthVar.ptr
                            )
                        }
                    }
                }
            }
            if (status != kCCSuccess) {
                return@runCatching value
            }
            outLength = outLengthVar.value.toInt()
        }
        return@runCatching outBuffer.copyOf(outLength)
    }

    private companion object {
        val AES_BLOCK_SIZE = kCCBlockSizeAES128.toInt()
    }
}