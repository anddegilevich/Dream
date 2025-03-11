package and.degilevich.dream.shared.logger

interface Logger {
    fun info(message: String)
    fun error(
        message: String,
        throwable: Throwable? = null
    )
}