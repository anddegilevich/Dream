package and.degilevich.dream.shared.logger.tracer

internal expect object ThreadTracer {
    fun getTrace(): String
}