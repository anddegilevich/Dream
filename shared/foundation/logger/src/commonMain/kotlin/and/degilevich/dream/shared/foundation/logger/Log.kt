package and.degilevich.dream.shared.foundation.logger

import and.degilevich.dream.shared.foundation.logger.tracer.Tracer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.LogLevel
import io.github.aakira.napier.Napier

//FIXME: Disable logger on release
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
        val trace = Tracer.getTrace(depth = TRACE_DEPTH)
        Napier.log(
            priority = priority,
            tag = LOG_TAG,
            throwable = throwable,
            message = "[$trace] $message"
        )
    }

    private const val LOG_TAG = "DREAM-LOG"
    private const val TRACE_DEPTH = 6
}