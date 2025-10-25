package and.degilevich.dream.shared.foundation.datetime.impl.current

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTimeConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class CurrentDateTimeImpl(
    private val locale: DateTimeLocale,
    private val logger: DateTimeLogger,
    private val instant: InstantWrapper,
    private val localDateTime: LocalDateTimeWrapper
) : CurrentDateTime {

    override fun currentTimeMillis(): Long {
        val milliseconds = instant.currentInstant().toEpochMilliseconds()
        logger.logInfo("currentTimeMillis:$milliseconds")
        return milliseconds
    }

    override fun currentDateTimeResult(block: CurrentDateTimeConfigBuilderScope.() -> Unit): Result<String> {
        return CurrentDateTimeConfigBuilderImpl().apply(block).build().foldResult { config ->
            instant.instantWithOffsetResult(
                instant = instant.currentInstant(),
                offset = config.offset,
                offsetUnit = config.offsetUnit
            ).foldResult { instantWithOffset ->
                localDateTime.instantToLocalDateTimeResult(
                    instant = instantWithOffset,
                    convertToLocal = if (config.format == DateTimeFormat.Defaults.TIMESTAMP) {
                        false
                    } else {
                        config.isConvertToLocal
                    }
                ).foldResult { localDatetimeByInstant ->
                    localDateTime.formatLocalDateTimeToStringResult(
                        localDateTime = localDatetimeByInstant,
                        formatTo = config.format,
                        localeCode = locale.getLocaleCode()
                    )
                }
            }
        }
    }

    override fun currentDateTime(block: CurrentDateTimeConfigBuilderScope.() -> Unit): String {
        return currentDateTimeResult(block).getOrNull().orEmpty()
    }
}