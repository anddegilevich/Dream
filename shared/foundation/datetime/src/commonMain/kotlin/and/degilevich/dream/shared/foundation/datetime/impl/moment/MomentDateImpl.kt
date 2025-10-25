package and.degilevich.dream.shared.foundation.datetime.impl.moment

import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentConfigBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime
import and.degilevich.dream.shared.foundation.primitive.result.foldResult
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
internal class MomentDateImpl(
    private val instant: InstantWrapper,
    private val localDateTime: LocalDateTimeWrapper,
    private val locale: DateTimeLocale
) : MomentDateTime {

    override fun startOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String> {
        return MomentConfigBuilderImpl().apply(block).build().foldResult { config ->
            instant.timeInstantResult(config.input).foldResult { instantByInput ->
                localDateTime.instantToLocalDateTimeResult(
                    instant = instantByInput,
                    convertToLocal = config.convertToLocal
                ).foldResult { localDateTimeByInput ->
                    val startLocalDateTime = localDateTime.startLocalDateTime(localDateTimeByInput, config.unit)
                    localDateTime.formatLocalDateTimeToStringResult(
                        localDateTime = startLocalDateTime,
                        formatTo = config.outputFormat,
                        localeCode = locale.getLocaleCode()
                    )
                }
            }
        }
    }

    override fun startOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String {
        return startOfDateUnitResult(block).getOrNull().orEmpty()
    }

    override fun endOfDateUnitResult(block: MomentConfigBuilderScope.() -> Unit): Result<String> {
        return MomentConfigBuilderImpl().apply(block).build().foldResult { config ->
            instant.timeInstantResult(config.input).foldResult { instantByInput ->
                localDateTime.instantToLocalDateTimeResult(
                    instant = instantByInput,
                    convertToLocal = config.convertToLocal
                ).foldResult { localDateTimeByInput ->
                    val startLocalDateTime = localDateTime.endLocalDateTime(localDateTimeByInput, config.unit)
                    localDateTime.formatLocalDateTimeToStringResult(
                        localDateTime = startLocalDateTime,
                        formatTo = config.outputFormat,
                        localeCode = locale.getLocaleCode()
                    )
                }
            }
        }
    }

    override fun endOfDateUnit(block: MomentConfigBuilderScope.() -> Unit): String {
        return endOfDateUnitResult(block).getOrNull().orEmpty()
    }
}