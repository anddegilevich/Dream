package and.degilevich.dream.shared.foundation.datetime.api.verification

import and.degilevich.dream.shared.foundation.datetime.impl.verification.VerificationDateConfig

internal interface VerificationDateConfigBuilder : VerificationDateBuilderScope {
    fun build(): Result<VerificationDateConfig>
}