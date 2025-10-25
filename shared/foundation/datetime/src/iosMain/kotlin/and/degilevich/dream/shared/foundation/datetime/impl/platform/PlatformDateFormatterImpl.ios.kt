package and.degilevich.dream.shared.foundation.datetime.impl.platform

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.NSTimeZone
import platform.Foundation.localTimeZone
import platform.Foundation.localeIdentifier

internal actual class PlatformDateFormatterImpl(
    private val locale: DateTimeLocale,
    private val logger: DateTimeLogger
) : PlatformDateFormatter {

    private val dateFormatterFrom by lazy { NSDateFormatter() }
    private val dateFormatterTo by lazy { NSDateFormatter() }

    @Suppress("TooGenericExceptionCaught")
    override fun toDateFormatResult(
        date: String,
        formatFrom: DateTimeFormat,
        formatTo: DateTimeFormat
    ): Result<String> {
        return try {
            val platformLocale = NSLocale(locale.getLocaleCode())
            logger.logInfo(
                buildString {
                    append("PlatformFormatterImpl.toDateFormatResult -> invoke")
                    append(" | ")
                    append("date:$date | formatFrom:$formatFrom | formatTo:$formatTo | ")
                    append("locale:${platformLocale.localeIdentifier}")
                }
            )
            dateFormatterFrom.apply {
                timeZone = NSTimeZone.localTimeZone
                locale = platformLocale
                dateFormat = formatFrom.format
            }
            dateFormatterTo.apply {
                timeZone = NSTimeZone.localTimeZone
                locale = platformLocale
                dateFormat = formatTo.format
            }
            val parsedDate = dateFormatterFrom.dateFromString(date)
            logger.logInfo("PlatformFormatterImpl.dateFormatFrom.dateFromString -> parsedDate:$parsedDate")
            if (parsedDate == null) {
                val error = PlatformFormatterException("date after parse is null | date:$date")
                logger.logError(error)
                return Result.failure(error)
            }
            val formattedDate = dateFormatterTo.stringFromDate(parsedDate)
            if (!isValidDateFormat(dateFormatterTo = dateFormatterTo, formattedDate = formattedDate)) {
                val error = PlatformFormatterException("invalid date format to | formattedDate:$formattedDate")
                logger.logError(error)
                Result.failure(error)
            } else {
                logger.logInfo("PlatformFormatterImpl.toDateFormatResult -> success | formattedDate:$formattedDate")
                Result.success(formattedDate)
            }
        } catch (e: Throwable) {
            logger.logError(e)
            Result.failure(e)
        }
    }

    private fun isValidDateFormat(dateFormatterTo: NSDateFormatter, formattedDate: String): Boolean {
        val parsedDate = dateFormatterTo.dateFromString(formattedDate) ?: return false
        val formattedString = dateFormatterTo.stringFromDate(parsedDate)
        return formattedDate == formattedString
    }
}