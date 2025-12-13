package and.degilevich.dream.shared.logger

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

    override fun error(throwable: Throwable) {
        error(
            message = throwable.message.orEmpty(),
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