package and.degilevich.dream.shared.foundation.datetime.impl.verification

import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shared.foundation.datetime.api.verification.VerificationDateConfigBuilder

internal class VerificationDateConfigBuilderImpl : VerificationDateConfigBuilder {
    private var inputMutable: DateTimeInput? = null
    private var convertToLocalMutable: Boolean = false

    override fun setInput(input: DateTimeInput) {
        inputMutable = input
    }

    override fun setConvertToLocal(isConverted: Boolean) {
        convertToLocalMutable = isConverted
    }

    override fun build(): Result<VerificationDateConfig> {
        val input = inputMutable
        val convertToLocal = convertToLocalMutable
        return when {
            input == null -> Result.failure(DateTimeVerificationConfigException("input is null"))
            else -> {
                Result.success(
                    VerificationDateConfig(
                        input = input,
                        isConvertToLocal = convertToLocal
                    )
                )
            }
        }
    }
}