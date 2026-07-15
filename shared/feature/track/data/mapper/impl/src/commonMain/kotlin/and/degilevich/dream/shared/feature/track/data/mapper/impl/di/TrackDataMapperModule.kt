package and.degilevich.dream.shared.feature.track.data.mapper.impl.di

import and.degilevich.dream.shared.feature.track.data.mapper.api.local.SimplifiedTrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.SimplifiedTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.impl.local.SimplifiedTrackDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.local.TrackDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.SimplifiedTrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.TrackOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDataMapperModule() = module {
    factoryOf(::SimplifiedTrackDataToEntityMapperImpl) bind SimplifiedTrackDataToEntityMapper::class
    factoryOf(::TrackDataToEntityMapperImpl) bind TrackDataToEntityMapper::class

    factoryOf(::SimplifiedTrackOutputToDataMapperImpl) bind SimplifiedTrackOutputToDataMapper::class
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class
}
