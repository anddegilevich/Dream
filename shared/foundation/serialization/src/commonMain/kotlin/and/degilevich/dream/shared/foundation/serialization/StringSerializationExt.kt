package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationException
import kotlinx.serialization.SerializationStrategy

fun <T> T.encodeToJson(serializer: SerializationStrategy<T>): Result<String> {
    return try {
        Result.success(
            json().encodeToString(
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

fun <T> T.encodeToJsonOrNull(serializer: SerializationStrategy<T>): String? {
    return encodeToJson(serializer = serializer).getOrNull()
}

fun <T> T.encodeToJsonOrEmpty(serializer: SerializationStrategy<T>): String {
    return encodeToJson(serializer = serializer).getOrDefault(defaultValue = "")
}

fun <T> String.decodeFromJson(deserializer: DeserializationStrategy<T>): Result<T> {
    return try {
        Result.success(
            json().decodeFromString(
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
