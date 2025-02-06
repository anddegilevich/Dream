package and.degilevich.dream.shared.core.client.impl.logger

import and.degilevich.dream.shared.core.logger.Log
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace
import io.ktor.client.plugins.logging.Logger
import kotlin.reflect.KClass

internal class ClientLogger<T : Any>(
    private val clientKClass: KClass<out T>
) : Logger {
    override fun log(message: String) {
        val modifiedMessage = buildString {
            append(clientKClass.className())
            appendSpace()
            append(message)
        }
        Log.info(modifiedMessage)
    }
}