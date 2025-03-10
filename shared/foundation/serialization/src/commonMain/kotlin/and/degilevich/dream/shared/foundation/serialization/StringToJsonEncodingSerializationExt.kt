package and.degilevich.dream.shared.foundation.serialization

import and.degilevich.dream.shared.foundation.serialization.json.jsonSerialization
import kotlinx.serialization.SerializationException
import kotlinx.serialization.SerializationStrategy

fun <T> T.encodeToJson(serializer: SerializationStrategy<T>): Result<String> {
    return try {
        Result.success(
            jsonSerialization().encodeToString(
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

inline fun <reified T> T.encodeToJson(): Result<String> {
    return try {
        Result.success(
            jsonSerialization().encodeToString(value = this)
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

inline fun <reified T> T.encodeToJsonOrNull(): String? {
    return encodeToJson().getOrNull()
}

inline fun <reified T> T.encodeToJsonOrEmpty(): String {
    return encodeToJson().getOrDefault(defaultValue = "")
}