package and.degilevich.dream.shated.feature.track.design.impl.di

import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.design.impl.mapper.TrackInfoToTrackCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDesignModule() = module {
    factoryOf(::TrackInfoToTrackCardUIDataMapperImpl) bind TrackInfoToTrackCardUIDataMapper::class
}