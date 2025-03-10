package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.json.jsonSerialization
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

fun <T> JsonElement.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return try {
        Result.success(
            jsonSerialization().decodeFromJsonElement(
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

inline fun <reified T> JsonElement.decodeFromJson(): Result<T> {
    return try {
        Result.success(
            jsonSerialization().decodeFromJsonElement(json = this)
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

inline fun <reified T> JsonElement.decodeFromJsonOrNull(): T? {
    return decodeFromJson<T>().getOrNull()
}

inline fun <reified T> JsonElement.decodeFromJsonOrDefault(
    default: () -> T
): T {
    return decodeFromJson<T>().getOrDefault(default())
}