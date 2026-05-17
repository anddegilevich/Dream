package and.degilevich.dream.shated.feature.track.ui.impl.di

import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.impl.mapper.TrackInfoToTrackCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackUiModule() = module {
    factoryOf(::TrackInfoToTrackCardUIDataMapperImpl) bind TrackInfoToTrackCardUIDataMapper::class
}