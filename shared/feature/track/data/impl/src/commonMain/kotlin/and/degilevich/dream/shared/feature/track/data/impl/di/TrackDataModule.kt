package and.degilevich.dream.shared.feature.track.data.impl.di

import and.degilevich.dream.shared.feature.track.data.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.data.api.local.mapper.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.api.local.mapper.TrackSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.track.data.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.api.remote.mapper.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.data.impl.local.TrackLocalDataSourceImpl
import and.degilevich.dream.shared.feature.track.data.impl.local.mapper.TrackDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.impl.local.mapper.TrackSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.TrackRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.mapper.GetTrackParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.mapper.GetTrackResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.mapper.TrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.mapper.TrackSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDataModule() = module {
    singleOf(::TrackRemoteDataSourceImpl) bind TrackRemoteDataSource::class
    singleOf(::TrackLocalDataSourceImpl) bind TrackLocalDataSource::class

    // Mapper
    factoryOf(::TrackSimplifiedDataToEntityMapperImpl) bind TrackSimplifiedDataToEntityMapper::class
    factoryOf(::TrackDataToEntityMapperImpl) bind TrackDataToEntityMapper::class

    factoryOf(::TrackSimplifiedOutputToDataMapperImpl) bind TrackSimplifiedOutputToDataMapper::class
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class

    factoryOf(::GetTrackParamsToRequestMapperImpl) bind GetTrackParamsToRequestMapper::class
    factoryOf(::GetTrackResponseToResultMapperImpl) bind GetTrackResponseToResultMapper::class
}