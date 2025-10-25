package and.degilevich.dream.shared.foundation.datetime.impl.format

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeSource
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter
import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class DateTimeFormatterImpl(
    private val locale: DateTimeLocale,
    private val instant: InstantWrapper,
    private val localDateTime: LocalDateTimeWrapper
) : DateTimeFormatter {

    override fun formatResult(block: DateTimeFormatConfigBuilderScope.() -> Unit): Result<String> {
        return DateTimeFormatConfigBuilderImpl().apply(block).build().foldResult { config ->
            when (val source = config.input.source) {
                is DateTimeSource.FromString -> {
                    instant.instantFromDateResult(
                        date = source.date,
                        format = source.format
                    ).foldResult { instantByDate ->
                        localDateTime.instantToLocalDateTimeResult(
                            instant = instantByDate,
                            convertToLocal = config.convertToLocal
                        )
                    }.foldResult { localDateTimeByInstant ->
                        localDateTime.formatLocalDateTimeToStringResult(
                            localDateTime = localDateTimeByInstant,
                            formatTo = config.output,
                            localeCode = locale.getLocaleCode()
                        )
                    }
                }

                is DateTimeSource.FromMillis -> {
                    val instant = instant.instantFromEpochMilliseconds(source.millis)
                    localDateTime.instantToLocalDateTimeResult(
                        instant = instant,
                        convertToLocal = config.convertToLocal
                    ).foldResult { localDateTimeByInstant ->
                        localDateTime.formatLocalDateTimeToStringResult(
                            localDateTime = localDateTimeByInstant,
                            formatTo = config.output,
                            localeCode = locale.getLocaleCode()
                        )
                    }
                }
            }
        }
    }

    override fun format(block: DateTimeFormatConfigBuilderScope.() -> Unit): String {
        return formatResult(block).getOrNull().orEmpty()
    }

    override fun formatToMillisResult(input: DateTimeInput): Result<Long> {
        return when (val source = input.source) {
            is DateTimeSource.FromMillis -> {
                val milliseconds = instant.instantFromEpochMilliseconds(source.millis).toEpochMilliseconds()
                Result.success(milliseconds)
            }

            is DateTimeSource.FromString -> {
                instant.instantFromDateResult(
                    date = source.date,
                    format = source.format
                ).foldResult { instant ->
                    val milliseconds = instant.toEpochMilliseconds()
                    Result.success(milliseconds)
                }
            }
        }
    }

    override fun formatToMillis(input: DateTimeInput): Long {
        return formatToMillisResult(input).getOrNull() ?: INVALID_VALUE
    }

    private companion object {
        const val INVALID_VALUE = -1L
    }
}