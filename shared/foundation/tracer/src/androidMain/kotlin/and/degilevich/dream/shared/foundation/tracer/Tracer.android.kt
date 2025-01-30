//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.foundation.tracer

import and.degilevich.dream.shared.foundation.primitive.stringBuilder.appendSpace

actual object Tracer {
    actual fun getTrace(depth: Int): String {
        val stackTrace = Thread.currentThread().stackTrace
        val callingElement = stackTrace.getOrNull(depth) ?: return ""
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