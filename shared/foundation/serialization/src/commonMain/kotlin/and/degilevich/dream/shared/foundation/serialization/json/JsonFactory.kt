package and.degilevich.dream.shared.foundation.serialization.json

import kotlinx.serialization.json.Json

fun jsonSerialization(): Json {
    return Json { ignoreUnknownKeys = true }
}