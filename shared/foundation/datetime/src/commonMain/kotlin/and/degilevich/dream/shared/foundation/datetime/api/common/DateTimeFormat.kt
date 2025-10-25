package and.degilevich.dream.shared.foundation.datetime.api.common

interface DateTimeFormat {
    val format: String

    fun isEmpty(): Boolean {
        return format.isEmpty()
    }

    enum class Defaults(
        override val format: String,
    ) : DateTimeFormat {
        ISO_8601(format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
        TIMESTAMP("yyyy-MM-dd'T'HH:mm:ssZ")
    }

    class Empty : DateTimeFormat {
        override val format: String = ""
    }
}