package and.degilevich.dream.shared.core.datetime.test

import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.between.TimeBetweenDates
import and.degilevich.dream.shared.foundation.datetime.api.current.CurrentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.format.DateTimeFormatter
import and.degilevich.dream.shared.foundation.datetime.api.moment.MomentDateTime
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification
import and.degilevich.dream.shared.core.datetime.test.between.FakeTimeBetweenDates
import and.degilevich.dream.shared.core.datetime.test.current.FakeCurrentDateTime
import and.degilevich.dream.shared.core.datetime.test.format.FakeDateTimeFormatter
import and.degilevich.dream.shared.core.datetime.test.moment.FakeMomentDateTime
import and.degilevich.dream.shared.core.datetime.test.verification.FakeDateTimeVerification

class FakeDateTime(
    override val current: CurrentDateTime = FakeCurrentDateTime(),
    override val formatter: DateTimeFormatter = FakeDateTimeFormatter(),
    override val verification: DateTimeVerification = FakeDateTimeVerification(),
    override val between: TimeBetweenDates = FakeTimeBetweenDates(),
    override val moment: MomentDateTime = FakeMomentDateTime()
) : DateTime
