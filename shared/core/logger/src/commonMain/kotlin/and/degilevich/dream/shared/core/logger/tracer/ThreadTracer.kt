package and.degilevich.dream.shared.core.logger.tracer

internal expect object ThreadTracer {
    fun getTrace(): String
}