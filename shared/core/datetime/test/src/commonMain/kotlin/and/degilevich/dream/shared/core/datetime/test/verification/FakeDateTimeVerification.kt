package and.degilevich.dream.shared.core.datetime.test.verification

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError
import and.degilevich.dream.shared.foundation.datetime.api.verification.DateTimeVerification
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateBuilderScope
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateWithOffsetBuilderScope

class FakeDateTimeVerification(
    private val onIsFutureDateWithOffsetResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsFutureDateWithOffset: () -> Boolean = { fakeImplementationError() },
    private val onIsPastDateWithOffsetResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsPastDateWithOffset: () -> Boolean = { fakeImplementationError() },
    private val onIsTodayResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsToday: () -> Boolean = { fakeImplementationError() },
    private val onIsYesterdayResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsYesterday: () -> Boolean = { fakeImplementationError() },
    private val onIsTomorrowResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsTomorrow: () -> Boolean = { fakeImplementationError() },
    private val onIsCurrentYearResult: () -> Result<Boolean> = { fakeImplementationError() },
    private val onIsCurrentYear: () -> Boolean = { fakeImplementationError() }
) : DateTimeVerification {

    override fun isFutureDateWithOffsetResult(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Result<Boolean> {
        return onIsFutureDateWithOffsetResult()
    }

    override fun isFutureDateWithOffset(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Boolean {
        return onIsFutureDateWithOffset()
    }

    override fun isPastDateWithOffsetResult(
        block: VerificationDateWithOffsetBuilderScope.() -> Unit
    ): Result<Boolean> {
        return onIsPastDateWithOffsetResult()
    }

    override fun isPastDateWithOffset(block: VerificationDateWithOffsetBuilderScope.() -> Unit): Boolean {
        return onIsPastDateWithOffset()
    }

    override fun isTodayResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean> {
        return onIsTodayResult()
    }

    override fun isToday(block: VerificationDateBuilderScope.() -> Unit): Boolean {
        return onIsToday()
    }

    override fun isYesterdayResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean> {
        return onIsYesterdayResult()
    }

    override fun isYesterday(block: VerificationDateBuilderScope.() -> Unit): Boolean {
        return onIsYesterday()
    }

    override fun isTomorrowResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean> {
        return onIsTomorrowResult()
    }

    override fun isTomorrow(block: VerificationDateBuilderScope.() -> Unit): Boolean {
        return onIsTomorrow()
    }

    override fun isCurrentYearResult(block: VerificationDateBuilderScope.() -> Unit): Result<Boolean> {
        return onIsCurrentYearResult()
    }

    override fun isCurrentYear(block: VerificationDateBuilderScope.() -> Unit): Boolean {
        return onIsCurrentYear()
    }
}
