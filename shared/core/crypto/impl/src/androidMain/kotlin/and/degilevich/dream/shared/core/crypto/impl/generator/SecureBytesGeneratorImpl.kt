package and.degilevich.dream.shared.core.crypto.impl.generator

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import java.security.SecureRandom

internal class SecureBytesGeneratorImpl : SecureBytesGenerator {

    private val secureRandom = SecureRandom()

    override fun generate(size: Int): ByteArray {
        return ByteArray(size).also(secureRandom::nextBytes)
    }
}
