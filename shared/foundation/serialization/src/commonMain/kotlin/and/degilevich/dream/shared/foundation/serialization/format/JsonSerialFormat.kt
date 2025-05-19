package and.degilevich.dream.shared.foundation.serialization.format

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.StringFormat
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.modules.SerializersModule

object JsonSerialFormat : StringFormat {

    val json: Json = Json {
        isLenient = true
        ignoreUnknownKeys = true
        useAlternativeNames = false
    }

    override val serializersModule: SerializersModule = json.serializersModule

    override fun <T> encodeToString(
        serializer: SerializationStrategy<T>,
        value: T
    ): String {
        return json.encodeToString(
            serializer = serializer,
            value = value
        )
    }

    override fun <T> decodeFromString(
        deserializer: DeserializationStrategy<T>,
        string: String
    ): T {
        return json.decodeFromString(
            deserializer = deserializer,
            string = string
        )
    }

    fun <T> encodeToJsonElement(
        serializer: SerializationStrategy<T>,
        value: T
    ): JsonElement {
        return json.encodeToJsonElement(
            serializer = serializer,
            value = value
        )
    }

    fun <T> decodeFromJsonElement(
        deserializer: DeserializationStrategy<T>,
        element: JsonElement
    ): T {
        return json.decodeFromJsonElement(
            deserializer = deserializer,
            element = element
        )
    }
}