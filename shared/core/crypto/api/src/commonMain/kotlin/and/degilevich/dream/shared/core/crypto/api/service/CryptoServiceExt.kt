package and.degilevich.dream.shared.core.crypto.api.service

import and.degilevich.dream.shared.foundation.primitive.result.foldResultSuccess
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun CryptoService.encrypt(value: String): Result<String> {
    val bytes = value.encodeToByteArray()
    return encrypt(bytes).foldResultSuccess { encryptedBytes ->
        Base64.encode(encryptedBytes)
    }
}

@OptIn(ExperimentalEncodingApi::class)
fun CryptoService.decrypt(value: String): Result<String> {
    val bytes = Base64.decode(value)
    return decrypt(bytes).foldResultSuccess { decryptedBytes ->
        decryptedBytes.decodeToString()
    }
}