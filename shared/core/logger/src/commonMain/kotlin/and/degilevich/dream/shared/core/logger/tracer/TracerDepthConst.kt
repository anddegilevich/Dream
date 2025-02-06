package and.degilevich.dream.shared.core.logger.tracer

// Depends on the amount of methods between the call of Log.trace and Tracer.getTrace.
// Differs between iOS and Android platforms.
internal expect val TRACER_DEPTH: Int