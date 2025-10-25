package and.degilevich.dream.shared.core.datetime.api

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat

enum class DreamDateTimeFormat(
    override val format: String
) : DateTimeFormat {
    YYYY_MM_DD("YYYY-MM-DD"),
    YYYY("YYYY")
}