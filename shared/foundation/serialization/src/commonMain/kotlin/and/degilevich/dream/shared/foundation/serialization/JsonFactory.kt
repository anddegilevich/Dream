package and.degilevich.dream.shared.foundation.serialization

import kotlinx.serialization.json.Json

internal fun json(): Json {
    return Json { ignoreUnknownKeys = true }
}