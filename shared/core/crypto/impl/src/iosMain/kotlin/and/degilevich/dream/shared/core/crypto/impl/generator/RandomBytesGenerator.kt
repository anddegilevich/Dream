package and.degilevich.dream.shared.core.crypto.impl.generator

internal interface RandomBytesGenerator {
    fun generate(size: Int): ByteArray
}