package and.degilevich.dream.shared.core.logger.tracer

// Depends on the amount of methods between the call of Logger methods and ThreadTracer.getTrace.
// Differs between iOS and Android platforms.
internal expect val THREAD_TRACER_DEPTH: Int