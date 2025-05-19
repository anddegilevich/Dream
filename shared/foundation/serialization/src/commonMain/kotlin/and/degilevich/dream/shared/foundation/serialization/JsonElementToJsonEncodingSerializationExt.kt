package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement

fun <T> T.encodeToJsonElement(serializer: SerializationStrategy<T>): Result<JsonElement> {
    return runCatching {
        JsonSerialFormat.encodeToJsonElement(
            serializer = serializer,
            value = this
        )
    }
}

fun <T> T.encodeToJsonElementOrNull(serializer: SerializationStrategy<T>): JsonElement? {
    return encodeToJsonElement(serializer = serializer).getOrNull()
}

fun <T> T.encodeToJsonElementOrEmpty(serializer: SerializationStrategy<T>): JsonElement {
    return encodeToJsonElement(serializer = serializer).getOrDefault(buildJsonObject { })
}

inline fun <reified T> T.encodeToJsonElement(): Result<JsonElement> {
    return runCatching {
        JsonSerialFormat.json.encodeToJsonElement(this)
    }
}

inline fun <reified T> T.encodeToJsonElementOrNull(): JsonElement? {
    return encodeToJsonElement().getOrNull()
}

inline fun <reified T> T.encodeToJsonElementOrEmpty(): JsonElement {
    return encodeToJsonElement().getOrDefault(buildJsonObject { })
}