package and.degilevich.dream.shared.foundation.datetime.api.common

sealed interface DateTimeSource {

    data class FromMillis(
        val millis: Long
    ) : DateTimeSource

    data class FromString(
        val date: String,
        val format: DateTimeFormat
    ) : DateTimeSource

    fun isEmpty(): Boolean {
        return when (this) {
            is FromString -> date.isEmpty()
            is FromMillis -> millis < 0
        }
    }
}