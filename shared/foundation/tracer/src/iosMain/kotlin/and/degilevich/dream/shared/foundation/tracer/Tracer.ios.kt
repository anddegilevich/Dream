//https://github.com/detekt/detekt/issues/7769
@file:Suppress("MatchingDeclarationName")

package and.degilevich.dream.shared.foundation.tracer

actual object Tracer {
    actual fun getTrace(depth: Int): String {
        return "" //FIXME: Implement later
    }
}