package and.degilevich.dream.shared.foundation.datetime.api.moment

import and.degilevich.dream.shared.foundation.datetime.impl.moment.MomentConfig

internal interface MomentConfigBuilder : MomentConfigBuilderScope {
    fun build(): Result<MomentConfig>
}