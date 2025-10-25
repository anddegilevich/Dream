package and.degilevich.dream.shared.foundation.datetime.api.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput

interface VerificationDateBuilderScope {
    fun setInput(input: DateTimeInput)
    fun setConvertToLocal(isConverted: Boolean)
}