package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.SerializationStrategy

fun <T> T.encodeToJson(serializer: SerializationStrategy<T>): Result<String> {
    return runCatching {
        JsonSerialFormat.encodeToString(
            serializer = serializer,
            value = this
        )
    }
}

fun <T> T.encodeToJsonOrNull(serializer: SerializationStrategy<T>): String? {
    return encodeToJson(serializer = serializer).getOrNull()
}

fun <T> T.encodeToJsonOrEmpty(serializer: SerializationStrategy<T>): String {
    return encodeToJson(serializer = serializer).getOrDefault(defaultValue = "")
}

inline fun <reified T> T.encodeToJson(): Result<String> {
    return runCatching {
        JsonSerialFormat.json.encodeToString(this)
    }
}

inline fun <reified T> T.encodeToJsonOrNull(): String? {
    return encodeToJson().getOrNull()
}

inline fun <reified T> T.encodeToJsonOrEmpty(): String {
    return encodeToJson().getOrDefault(defaultValue = "")
}