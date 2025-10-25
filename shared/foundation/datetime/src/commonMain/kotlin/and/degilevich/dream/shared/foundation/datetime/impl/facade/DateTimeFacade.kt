package and.degilevich.dream.shared.foundation.datetime.impl.facade

import and.degilevich.dream.shared.foundation.datetime.api.instant.InstantWrapper
import and.degilevich.dream.shared.foundation.datetime.api.instantLocalDateTime.InstantLocalDateTime
import and.degilevich.dream.shared.foundation.datetime.api.localDateTime.LocalDateTimeWrapper
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter
import and.degilevich.dream.shared.foundation.datetime.api.timezone.TimeZoneWrapper
import and.degilevich.dream.shared.foundation.datetime.api.unit.TimeUnitToDateTimeUnitMapper
import and.degilevich.dream.shared.foundation.datetime.impl.instant.InstantWrapperImpl
import and.degilevich.dream.shared.foundation.datetime.impl.instantLocalDateTime.InstantLocalDateTimeImpl
import and.degilevich.dream.shared.foundation.datetime.impl.localDateTime.LocalDateTimeWrapperImpl
import and.degilevich.dream.shared.foundation.datetime.impl.platform.PlatformDateFormatterFactory
import and.degilevich.dream.shared.foundation.datetime.impl.timezone.TimeZoneWrapperImpl
import and.degilevich.dream.shared.foundation.datetime.impl.unit.TimeUnitToDateTimeUnitMapperImpl

internal class DateTimeFacade(
    private val locale: DateTimeLocale,
    private val logger: DateTimeLogger
) {
    internal val timeZone: TimeZoneWrapper by lazy { TimeZoneWrapperImpl(logger = logger) }
    private val platformDateFormatter: PlatformDateFormatter by lazy {
        PlatformDateFormatterFactory().create(
            locale = locale,
            logger = logger
        )
    }
    private val timeUnitToDateTimeUnitMapper: TimeUnitToDateTimeUnitMapper by lazy {
        TimeUnitToDateTimeUnitMapperImpl()
    }
    internal val instant: InstantWrapper by lazy {
        InstantWrapperImpl(
            logger = logger,
            platformDateFormatter = platformDateFormatter,
            timeUnitMapper = timeUnitToDateTimeUnitMapper
        )
    }
    internal val localDateTime: LocalDateTimeWrapper by lazy {
        LocalDateTimeWrapperImpl(
            logger = logger,
            timeZone = timeZone,
            platformFormatter = platformDateFormatter
        )
    }
    internal val instantLocalDateTime: InstantLocalDateTime by lazy {
        InstantLocalDateTimeImpl(
            instant = instant,
            localDateTime = localDateTime
        )
    }
}