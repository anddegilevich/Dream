package and.degilevich.dream.shared.foundation.logger

interface Logger {
    fun info(message: String)
    fun error(
        message: String,
        throwable: Throwable? = null
    )
}