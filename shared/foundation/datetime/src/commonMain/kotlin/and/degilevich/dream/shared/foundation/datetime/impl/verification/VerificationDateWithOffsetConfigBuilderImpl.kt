package and.degilevich.dream.shared.foundation.datetime.impl.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateWithOffsetConfigBuilder
import kotlin.time.Duration

internal class VerificationDateWithOffsetConfigBuilderImpl : VerificationDateWithOffsetConfigBuilder {

    private var inputMutable: DateTimeInput? = null
    private var durationMutable: Duration? = null

    override fun setInput(input: DateTimeInput) {
        inputMutable = input
    }

    override fun setOffset(duration: Duration) {
        this.durationMutable = duration
    }

    override fun build(): Result<VerificationDateWithOffsetConfig> {
        val input = inputMutable
        val duration = durationMutable
        return when {
            input == null -> Result.failure(DateTimeVerificationConfigException("input is null"))
            duration == null -> Result.failure(DateTimeVerificationConfigException("duration is null"))
            else -> {
                Result.success(
                    VerificationDateWithOffsetConfig(
                        input = input,
                        duration = duration
                    )
                )
            }
        }
    }
}