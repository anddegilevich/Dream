package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.SerializationException
import kotlinx.serialization.encodeToString

inline fun <reified T> T.encodeToJson(): Result<String> {
    return try {
        Result.success(json().encodeToString(this))
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

inline fun <reified T> String.decodeFromJson(): Result<T> {
    return try {
        Result.success(
            json().decodeFromString<T>(this)
        )
    } catch (error: SerializationException) {
        Result.failure(error)
    } catch (error: IllegalArgumentException) {
        Result.failure(error)
    }
}

inline fun <reified T> String.decodeFromJsonOrNull(): T? {
    return decodeFromJson<T>().getOrNull()
}

inline fun <reified T> String.decodeFromJsonOrDefault(default: () -> T): T {
    return decodeFromJson<T>().getOrDefault(default())
}
