package and.degilevich.dream.shared.foundation.datetime.api.between

import and.degilevich.dream.shared.foundation.datetime.impl.between.TimeBetweenNowAndDateConfig

internal interface TimeBetweenNowAndDateConfigBuilder : TimeBetweenNowAndDateConfigBuilderScope {
    fun build(): Result<TimeBetweenNowAndDateConfig>
}