package and.degilevich.dream.shared.core.crypto.api.generator

interface SecureBytesGenerator {
    fun generate(size: Int): ByteArray
}