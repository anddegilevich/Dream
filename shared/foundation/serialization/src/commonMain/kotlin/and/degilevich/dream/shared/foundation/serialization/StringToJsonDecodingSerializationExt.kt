package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer

fun <T> String.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return try {
        Result.success(
            JsonSerialFormat.decodeFromString(
                deserializer = deserializer,
                string = this
            )
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

fun <T> String.decodeFromJsonOrNull(deserializer: DeserializationStrategy<T>): T? {
    return decodeFromJson(deserializer = deserializer).getOrNull()
}

fun <T> String.decodeFromJsonOrDefault(
    deserializer: DeserializationStrategy<T>,
    default: () -> T
): T {
    return decodeFromJson(deserializer = deserializer).getOrDefault(default())
}

inline fun <reified T> String.decodeFromJson(): Result<T> {
    return decodeFromJson(
        deserializer = JsonSerialFormat.serializersModule.serializer()
    )
}

inline fun <reified T> String.decodeFromJsonOrNull(): T? {
    return decodeFromJson<T>().getOrNull()
}

inline fun <reified T> String.decodeFromJsonOrDefault(default: () -> T): T {
    return decodeFromJson<T>().getOrDefault(default())
}