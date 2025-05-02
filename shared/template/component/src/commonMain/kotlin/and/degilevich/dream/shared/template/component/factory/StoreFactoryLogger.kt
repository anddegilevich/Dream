package and.degilevich.dream.shared.template.component.factory

import and.degilevich.dream.shared.logger.Log
import com.arkivanov.mvikotlin.logging.logger.Logger

internal class StoreFactoryLogger : Logger {
    override fun log(text: String) {
        Log.info(message = text)
    }
}