package and.degilevich.dream.shared.foundation.datetime.impl.platform

import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter

internal actual class PlatformDateFormatterFactory {

    actual fun create(
        locale: DateTimeLocale,
        logger: DateTimeLogger
    ): PlatformDateFormatter {
        return PlatformDateFormatterImpl(
            locale = locale,
            logger = logger
        )
    }
}