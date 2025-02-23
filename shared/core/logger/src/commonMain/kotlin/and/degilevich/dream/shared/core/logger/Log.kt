package and.degilevich.dream.shared.core.logger

import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace
import and.degilevich.dream.shared.core.logger.tracer.ThreadTracer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.Napier

//FIXME: Disable logger for release builds
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

    override fun trace(message: String) {
        val trace = ThreadTracer.getTrace()
        log(
            priority = LogLevel.INFO,
            message = buildString {
                if (trace.isNotEmpty()) {
                    append("[$trace]")
                    appendSpace()
                }
                append(message)
            }
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
        Napier.log(
            priority = priority,
            tag = LOG_TAG,
            throwable = throwable,
            message = message
        )
    }

    private const val LOG_TAG = "DREAM-LOG"
}