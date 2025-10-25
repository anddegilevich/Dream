package and.degilevich.dream.shared.foundation.datetime.api.logger

interface DateTimeLogger {

    fun logInfo(text: String)
    fun logError(error: Throwable)

    class Empty : DateTimeLogger {
        override fun logInfo(text: String) = Unit
        override fun logError(error: Throwable) = Unit
    }
}