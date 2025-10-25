package and.degilevich.dream.shared.foundation.datetime.api.current

import and.degilevich.dream.shared.foundation.datetime.impl.current.CurrentDateConfig

internal interface CurrentDateTimeConfigBuilder : CurrentDateTimeConfigBuilderScope {
    fun build(): Result<CurrentDateConfig>
}