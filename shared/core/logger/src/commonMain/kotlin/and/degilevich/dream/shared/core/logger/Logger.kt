package and.degilevich.dream.shared.core.logger

interface Logger {
    fun info(message: String)
    fun trace(message: String)
    fun error(
        message: String,
        throwable: Throwable? = null
    )
}