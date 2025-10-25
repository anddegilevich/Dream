package and.degilevich.dream.shared.foundation.datetime.api

import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification
import and.degilevich.dream.shared.foundation.datetime.impl.between.TimeBetweenDatesImpl
import and.degilevich.dream.shared.foundation.datetime.impl.current.CurrentDateTimeImpl
import and.degilevich.dream.shared.foundation.datetime.impl.facade.DateTimeFacade
import and.degilevich.dream.shared.foundation.datetime.impl.format.DateTimeFormatterImpl
import and.degilevich.dream.shared.foundation.datetime.impl.moment.MomentDateImpl
import and.degilevich.dream.shared.foundation.datetime.impl.verification.DateTimeVerificationImpl

class DateTimeHelper(
    locale: DateTimeLocale = DateTimeLocale.English(),
    logger: DateTimeLogger = DateTimeLogger.Empty()
) : DateTime {

    private val facade by lazy { DateTimeFacade(locale = locale, logger = logger) }

    override val current: CurrentDateTime by lazy {
        CurrentDateTimeImpl(
            locale = locale,
            logger = logger,
            instant = facade.instant,
            localDateTime = facade.localDateTime
        )
    }

    override val formatter: DateTimeFormatter by lazy {
        DateTimeFormatterImpl(
            locale = locale,
            instant = facade.instant,
            localDateTime = facade.localDateTime
        )
    }

    override val verification: DateTimeVerification by lazy {
        DateTimeVerificationImpl(
            instant = facade.instant,
            timeZone = facade.timeZone,
            localDateTime = facade.localDateTime
        )
    }

    override val between: TimeBetweenDates by lazy {
        TimeBetweenDatesImpl(
            instant = facade.instant,
            localDateTime = facade.localDateTime,
            timeZone = facade.timeZone,
            instantLocalDateTime = facade.instantLocalDateTime
        )
    }

    override val moment: MomentDateTime by lazy {
        MomentDateImpl(
            instant = facade.instant,
            localDateTime = facade.localDateTime,
            locale = locale
        )
    }
}