package and.degilevich.dream.shared.logger.tracer

//import platform.Foundation.NSThread.Companion.callStackSymbols

internal actual object ThreadTracer {
    actual fun getTrace(): String {
        return "" // FIXME: Performance issues
//        val trace = callStackSymbols.getOrNull(THREAD_TRACER_DEPTH)?.toString().orEmpty()
//        return formatTrace(trace)
    }

//    private fun formatTrace(trace: String): String {
//        return trace
//            .replace(LONG_SPACE_REGEX.toRegex(), " ")
//            .split(" ")
//            .getOrNull(TRACE_MAIN_INFO_INDEX)
//            .orEmpty()
//            .removePrefix(KMM_PREFIX)
//    }
//
//    private const val TRACE_MAIN_INFO_INDEX = 3
//    private const val LONG_SPACE_REGEX = "\\s+"
//    private const val KMM_PREFIX = "kfun:"
}