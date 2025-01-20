package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

inline fun <reified T> T.encodeToJsonElement(): Result<JsonElement> {
    return try {
        Result.success(
            json().encodeToJsonElement(this)
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

inline fun <reified T> JsonElement.decodeFromJson(): Result<T> {
    return try {
        Result.success(
            json().decodeFromJsonElement<T>(this)
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

inline fun <reified T> JsonElement.decodeFromJsonOrDefault(default: () -> T): T {
    return decodeFromJson<T>().getOrDefault(default())
}
