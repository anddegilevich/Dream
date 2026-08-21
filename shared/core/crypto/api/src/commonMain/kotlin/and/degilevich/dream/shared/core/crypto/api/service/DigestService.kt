package and.degilevich.dream.shared.core.crypto.api.service

interface DigestService {
    fun sha256(value: ByteArray): ByteArray
}