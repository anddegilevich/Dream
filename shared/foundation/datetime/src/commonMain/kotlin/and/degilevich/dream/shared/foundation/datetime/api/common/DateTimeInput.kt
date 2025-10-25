package and.degilevich.dream.shared.foundation.datetime.api.common

interface DateTimeInput {

    val source: DateTimeSource

    fun isEmpty(): Boolean = source.isEmpty()

    class FromMillis(
        millis: Long,
    ) : DateTimeInput {
        override val source: DateTimeSource = DateTimeSource.FromMillis(millis = millis)
    }

    class FromString(
        date: String,
        format: DateTimeFormat,
    ) : DateTimeInput {
        override val source: DateTimeSource = DateTimeSource.FromString(
            date = date,
            format = format
        )
    }
}