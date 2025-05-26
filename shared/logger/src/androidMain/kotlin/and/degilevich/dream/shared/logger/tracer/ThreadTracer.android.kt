package and.degilevich.dream.shared.logger.tracer

import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace

internal actual object ThreadTracer {
    actual fun getTrace(): String {
        val stackTrace = Thread.currentThread().stackTrace
        val callingElement = stackTrace.getOrNull(THREAD_TRACER_DEPTH) ?: return ""
        return buildString {
            callingElement.className
                .split(".")
                .lastOrNull()?.let { className ->
                    append(className)
                }
            append(".")
            append(callingElement.methodName)
            appendSpace()
            append(callingElement.fileName)
            append(":")
            append(callingElement.lineNumber)
        }
    }
}