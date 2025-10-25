package and.degilevich.dream.shared.foundation.datetime.impl.platform

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeFormat
import and.degilevich.dream.shared.foundation.datetime.api.locale.DateTimeLocale
import and.degilevich.dream.shared.foundation.datetime.api.logger.DateTimeLogger
import and.degilevich.dream.shared.foundation.datetime.api.platform.PlatformDateFormatter
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

internal actual class PlatformDateFormatterImpl(
    private val locale: DateTimeLocale,
    private val logger: DateTimeLogger,
) : PlatformDateFormatter {

    override fun toDateFormatResult(
        date: String,
        formatFrom: DateTimeFormat,
        formatTo: DateTimeFormat
    ): Result<String> {
        val platformLocale = Locale(locale.getLocaleCode())
        logger.logInfo(
            buildString {
                append("PlatformFormatterImpl.toDateFormatResult -> invoke")
                append(" | ")
                append("date:$date | formatFrom:$formatFrom | formatTo:$formatTo | locale:$platformLocale")
            }
        )
        return try {
            val dateFormatFrom = SimpleDateFormat(formatFrom.format, platformLocale)
            val dateFormatTo = SimpleDateFormat(formatTo.format, platformLocale)
            val parsedDate = dateFormatFrom.parse(date)
            if (parsedDate == null) {
                val error = PlatformFormatterException("date after parse is null | date:$date")
                logger.logError(error)
                return Result.failure(error)
            }
            val formattedDate = dateFormatTo.format(parsedDate)
            logger.logInfo("PlatformFormatterImpl.toDateFormatResult -> success | formattedDate:$formattedDate")
            Result.success(formattedDate)
        } catch (e: IllegalArgumentException) {
            logger.logError(e)
            Result.failure(e)
        } catch (e: ParseException) {
            logger.logError(e)
            Result.failure(e)
        }
    }
}