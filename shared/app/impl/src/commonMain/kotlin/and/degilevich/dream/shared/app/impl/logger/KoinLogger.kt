package and.degilevich.dream.shared.app.impl.logger

import and.degilevich.dream.shared.logger.Log
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

class KoinLogger : Logger() {
    override fun display(level: Level, msg: MESSAGE) {
        when (level) {
            Level.NONE,
            Level.DEBUG,
            Level.INFO -> Log.info(msg)

            Level.WARNING,
            Level.ERROR -> Log.error(msg)
        }
    }
}