package and.degilevich.dream.shared.logger

import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace
import and.degilevich.dream.shared.logger.tracer.ThreadTracer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.Napier

object Log : Logger {

    fun init() {
        Napier.base(DebugAntilog())
    }

    override fun info(message: String) {
        log(
            priority = LogLevel.INFO,
            message = message
        )
    }

    override fun error(
        message: String,
        throwable: Throwable?
    ) {
        log(
            priority = LogLevel.ERROR,
            message = message,
            throwable = throwable
        )
    }

    @Suppress("MemberNameEqualsClassName")
    private fun log(
        priority: LogLevel,
        message: String,
        throwable: Throwable? = null
    ) {
        val trace = ThreadTracer.getTrace()
        val modifiedMessage = buildString {
            if (trace.isNotEmpty()) {
                append("[$trace]")
                appendSpace()
            }
            append(message)
        }
        Napier.log(
            priority = priority,
            tag = LOG_TAG,
            throwable = throwable,
            message = modifiedMessage
        )
    }

    private const val LOG_TAG = "DREAM-LOG"
}