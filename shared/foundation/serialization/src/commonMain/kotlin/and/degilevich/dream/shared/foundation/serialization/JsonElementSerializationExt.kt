package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject

fun <T> T.encodeToJsonElement(serializer: SerializationStrategy<T>): Result<JsonElement> {
    return try {
        Result.success(
            json().encodeToJsonElement(
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

fun <T> JsonElement.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return try {
        Result.success(
            json().decodeFromJsonElement(
                deserializer = deserializer,
                element = this
            )
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

fun <T> JsonElement.decodeFromJsonOrNull(deserializer: DeserializationStrategy<T>): T? {
    return decodeFromJson(deserializer = deserializer).getOrNull()
}

fun <T> JsonElement.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: () -> T
): T {
    return decodeFromJson(deserializer = deserializer).getOrDefault(default())
}
