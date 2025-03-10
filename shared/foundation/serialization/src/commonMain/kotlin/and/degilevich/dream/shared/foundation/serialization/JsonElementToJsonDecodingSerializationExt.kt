package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.serializer

fun <T> JsonElement.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return try {
        Result.success(
            JsonSerialFormat.decodeFromJsonElement(
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
    return decodeFromJson(
        deserializer = JsonSerialFormat.serializersModule.serializer<T>()
    )
}

inline fun <reified T> JsonElement.decodeFromJsonOrNull(): T? {
    return decodeFromJson<T>().getOrNull()
}

inline fun <reified T> JsonElement.decodeFromJsonOrDefault(
    default: () -> T
): T {
    return decodeFromJson<T>().getOrDefault(default())
}