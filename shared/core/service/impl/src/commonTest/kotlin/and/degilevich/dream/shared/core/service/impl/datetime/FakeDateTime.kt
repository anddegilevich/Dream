package and.degilevich.dream.shared.core.service.impl.datetime

import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification

internal class FakeDateTime(
    override val current: CurrentDateTime = FakeCurrentDateTime(),
    override val formatter: DateTimeFormatter = FakeDateTimeFormatter(),
    override val verification: DateTimeVerification = FakeDateTimeVerification(),
    override val between: TimeBetweenDates = FakeTimeBetweenDates(),
    override val moment: MomentDateTime = FakeMomentDateTime()
) : DateTime
