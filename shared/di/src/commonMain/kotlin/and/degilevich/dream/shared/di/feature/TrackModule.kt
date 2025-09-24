package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.track.domain.impl.di.trackDomainModule
import and.degilevich.dream.shared.feature.track.source.impl.di.trackSourceModule
import and.degilevich.dream.shated.feature.track.design.impl.di.trackDesignModule
import org.koin.dsl.module

internal fun trackModule() = module {
    includes(trackSourceModule())
    includes(trackDomainModule())
    includes(trackDesignModule())
}