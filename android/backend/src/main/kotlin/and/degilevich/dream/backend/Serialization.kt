package and.degilevich.dream.backend

import and.degilevich.dream.shared.foundation.serialization.format.JsonSerialFormat
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            json = JsonSerialFormat.json
        )
    }
}
