package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.json.jsonSerialization
import kotlinx.serialization.SerializationException
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement

fun <T> T.encodeToJsonElement(serializer: SerializationStrategy<T>): Result<JsonElement> {
    return try {
        Result.success(
            jsonSerialization().encodeToJsonElement(
                serializer = serializer,
                value = this
            )
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

fun <T> T.encodeToJsonElementOrNull(serializer: SerializationStrategy<T>): JsonElement? {
    return encodeToJsonElement(serializer = serializer).getOrNull()
}

fun <T> T.encodeToJsonElementOrEmpty(serializer: SerializationStrategy<T>): JsonElement {
    return encodeToJsonElement(serializer = serializer).getOrDefault(buildJsonObject { })
}

inline fun <reified T> T.encodeToJsonElement(): Result<JsonElement> {
    return try {
        Result.success(
            jsonSerialization().encodeToJsonElement(value = this)
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

inline fun <reified T> T.encodeToJsonElementOrNull(): JsonElement? {
    return encodeToJsonElement().getOrNull()
}

inline fun <reified T> T.encodeToJsonElementOrEmpty(): JsonElement {
    return encodeToJsonElement().getOrDefault(buildJsonObject { })
}