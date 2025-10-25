package and.degilevich.dream.shared.foundation.datetime.api.between

import and.degilevich.dream.shared.foundation.datetime.impl.between.TimeBetweenDatesConfig

internal interface TimeBetweenDatesConfigBuilder : TimeBetweenDatesConfigBuilderScope {
    fun build(): Result<TimeBetweenDatesConfig>
}