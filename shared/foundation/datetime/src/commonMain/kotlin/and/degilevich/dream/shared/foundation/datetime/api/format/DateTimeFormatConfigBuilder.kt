package and.degilevich.dream.shared.foundation.datetime.api.format

import and.degilevich.dream.shared.foundation.datetime.impl.format.DateTimeFormatConfig

internal interface DateTimeFormatConfigBuilder : DateTimeFormatConfigBuilderScope {
    fun build(): Result<DateTimeFormatConfig>
}