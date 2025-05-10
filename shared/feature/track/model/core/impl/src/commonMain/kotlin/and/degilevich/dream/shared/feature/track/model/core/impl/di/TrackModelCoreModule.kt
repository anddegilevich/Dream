package and.degilevich.dream.shared.feature.track.model.core.impl.di

import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.TrackOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackModelCoreModule() = module {
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class
}