package and.degilevich.dream.shared.app.impl.logger

import and.degilevich.dream.shared.foundation.logger.Log
import com.arkivanov.mvikotlin.logging.logger.Logger

class StoreFactoryLogger : Logger {
    override fun log(text: String) {
        Log.info(message = text)
    }
}