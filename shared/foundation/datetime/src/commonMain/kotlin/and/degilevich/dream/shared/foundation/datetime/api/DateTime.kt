package and.degilevich.dream.shared.foundation.datetime.api

import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification

interface DateTime {
    val current: CurrentDateTime
    val formatter: DateTimeFormatter
    val verification: DateTimeVerification
    val between: TimeBetweenDates
    val moment: MomentDateTime
}