package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

fun <T> JsonElement.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return runCatching {
        JsonSerialFormat.decodeFromJsonElement(
            deserializer = deserializer,
            element = this
        )
    }
}

fun <T> JsonElement.decodeFromJsonOrNull(deserializer: DeserializationStrategy<T>): T? {
    return decodeFromJson(deserializer = deserializer).getOrNull()
}

inline fun <T> JsonElement.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: () -> T
): T {
    return decodeFromJson(deserializer = deserializer).getOrDefault(default())
}

fun <T> JsonElement.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: T
): T {
    return decodeFromJsonOrDefault(deserializer = deserializer) { default }
}

inline fun <reified T> JsonElement.decodeFromJson(): Result<T> {
    return runCatching {
        JsonSerialFormat.json.decodeFromJsonElement(this)
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

inline fun <reified T> JsonElement.decodeFromJsonOrDefault(
    default: T
): T {
    return decodeFromJsonOrDefault<T> { default }
}