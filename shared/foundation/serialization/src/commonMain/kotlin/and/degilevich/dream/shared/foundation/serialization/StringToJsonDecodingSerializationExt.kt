package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.DeserializationStrategy

fun <T> String.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return runCatching {
        JsonSerialFormat.decodeFromString(
            deserializer = deserializer,
            string = this
        )
    }
}

fun <T> String.decodeFromJsonOrNull(deserializer: DeserializationStrategy<T>): T? {
    return decodeFromJson(deserializer = deserializer).getOrNull()
}

inline fun <T> String.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: () -> T
): T {
    return decodeFromJson(deserializer = deserializer).getOrDefault(default())
}

fun <T> String.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: T
): T {
    return decodeFromJsonOrDefault(deserializer = deserializer) { default }
}

inline fun <reified T> String.decodeFromJson(): Result<T> {
    return runCatching {
        JsonSerialFormat.json.decodeFromString(this)
    }
}

inline fun <reified T> String.decodeFromJsonOrNull(): T? {
    return decodeFromJson<T>().getOrNull()
}

inline fun <reified T> String.decodeFromJsonOrDefault(default: () -> T): T {
    return decodeFromJson<T>().getOrDefault(default())
}

inline fun <reified T> String.decodeFromJsonOrDefault(default: T): T {
    return decodeFromJsonOrDefault<T> { default }
}