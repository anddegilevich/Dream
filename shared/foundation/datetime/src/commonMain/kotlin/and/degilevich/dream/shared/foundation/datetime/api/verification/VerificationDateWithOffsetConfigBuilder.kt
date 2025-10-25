package and.degilevich.dream.shared.foundation.datetime.api.verification

import and.degilevich.dream.shared.foundation.datetime.impl.verification.VerificationDateWithOffsetConfig

internal interface VerificationDateWithOffsetConfigBuilder : VerificationDateWithOffsetBuilderScope {
    fun build(): Result<VerificationDateWithOffsetConfig>
}