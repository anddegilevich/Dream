package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

fun String.prettyPrintJson(): Result<String> {
    val json = Json { prettyPrint = true }
    return runCatching {
        val jsonElement = json.parseToJsonElement(string = this)
        json.encodeToString(
            serializer = JsonElement.serializer(),
            value = jsonElement
        )
    }
}

fun String.prettyPrintJsonOrNull(): String? {
    return prettyPrintJson().getOrNull()
}

fun String.prettyPrintJsonOrEmpty(): String {
    return prettyPrintJson().getOrElse { "" }
}

fun String.tryPrettyPrintJson(): String {
    return prettyPrintJson().getOrElse { this }
}