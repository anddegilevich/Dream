//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.core.logger.tracer

import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace

internal actual object Tracer {
    actual fun getTrace(): String {
        val stackTrace = Thread.currentThread().stackTrace
        val callingElement = stackTrace.getOrNull(TRACER_DEPTH) ?: return ""
        return buildString {
            append(callingElement.className)
            append(".")
            append(callingElement.methodName)
            appendSpace()
            append(callingElement.fileName)
            append(":")
            append(callingElement.lineNumber)
        }
    }
}