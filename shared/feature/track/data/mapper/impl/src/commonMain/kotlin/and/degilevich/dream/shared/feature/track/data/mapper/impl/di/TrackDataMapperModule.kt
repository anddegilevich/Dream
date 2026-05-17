package and.degilevich.dream.shared.feature.track.data.mapper.impl.di

import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.local.TrackSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.api.remote.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.mapper.impl.local.TrackDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.local.TrackSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.GetTrackParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.GetTrackResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.TrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.track.data.mapper.impl.remote.TrackSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDataMapperModule() = module {
    factoryOf(::TrackSimplifiedDataToEntityMapperImpl) bind TrackSimplifiedDataToEntityMapper::class
    factoryOf(::TrackDataToEntityMapperImpl) bind TrackDataToEntityMapper::class

    factoryOf(::TrackSimplifiedOutputToDataMapperImpl) bind TrackSimplifiedOutputToDataMapper::class
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class

    factoryOf(::GetTrackParamsToRequestMapperImpl) bind GetTrackParamsToRequestMapper::class
    factoryOf(::GetTrackResponseToResultMapperImpl) bind GetTrackResponseToResultMapper::class
}
