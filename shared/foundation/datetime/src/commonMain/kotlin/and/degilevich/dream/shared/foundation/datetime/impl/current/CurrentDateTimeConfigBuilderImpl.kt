package and.degilevich.dream.shared.foundation.datetime.impl.current

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTimeConfigBuilder
import and.degilevich.dream.shared.foundation.datetime.impl.common.TimeUnit

internal class CurrentDateTimeConfigBuilderImpl : CurrentDateTimeConfigBuilder {
    private var isConvertToLocalMutable: Boolean = false
    private var outputFormatMutable: DateTimeFormat = DateTimeFormat.Empty()
    private var offsetToUnitMutable: Pair<Int, TimeUnit> = 0 to TimeUnit.MILLISECOND

    override fun setConvertToLocal(isConverted: Boolean) {
        isConvertToLocalMutable = isConverted
    }

    override fun setOutputFormat(format: DateTimeFormat) {
        outputFormatMutable = format
    }

    override fun setOffset(
        offset: Int,
        unit: TimeUnit,
    ) {
        this.offsetToUnitMutable = offset to unit
    }

    override fun build(): Result<CurrentDateConfig> {
        return if (outputFormatMutable.isEmpty()) {
            Result.failure(Exception("output format is empty"))
        } else {
            Result.success(
                CurrentDateConfig(
                    format = outputFormatMutable,
                    isConvertToLocal = isConvertToLocalMutable,
                    offset = offsetToUnitMutable.first,
                    offsetUnit = offsetToUnitMutable.second
                )
            )
        }
    }
}