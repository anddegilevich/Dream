package and.degilevich.dream.shared.core.crypto.impl.generator

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.usePinned
import platform.Security.SecRandomCopyBytes
import platform.Security.errSecSuccess
import platform.Security.kSecRandomDefault

@OptIn(ExperimentalForeignApi::class)
internal class SecureBytesGeneratorImpl : SecureBytesGenerator {

    override fun generate(size: Int): ByteArray {
        val array = ByteArray(size)
        array.usePinned { pinned ->
            val status = SecRandomCopyBytes(
                kSecRandomDefault,
                size.convert(),
                pinned.addressOf(0)
            )
            check(status == errSecSuccess) {
                "SecRandomCopyBytes failed: $status"
            }
        }
        return array
    }
}