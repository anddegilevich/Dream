package and.degilevich.dream.shared.foundation.logger.tracer

internal expect object Tracer {
    fun getTrace(depth: Int): String
}