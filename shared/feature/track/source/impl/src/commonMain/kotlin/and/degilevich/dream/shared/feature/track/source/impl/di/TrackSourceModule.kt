package and.degilevich.dream.shared.feature.track.source.impl.di

import and.degilevich.dream.shared.feature.track.source.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackDataToEntityMapper
import and.degilevich.dream.shared.feature.track.source.api.local.mapper.TrackSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.source.api.remote.mapper.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.source.impl.local.TrackLocalDataSourceImpl
import and.degilevich.dream.shared.feature.track.source.impl.local.mapper.TrackDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.local.mapper.TrackSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.TrackRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.TrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.TrackSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackSourceModule() = module {
    singleOf(::TrackRemoteDataSourceImpl) bind TrackRemoteDataSource::class
    singleOf(::TrackLocalDataSourceImpl) bind TrackLocalDataSource::class

    // Mapper
    factoryOf(::TrackSimplifiedDataToEntityMapperImpl) bind TrackSimplifiedDataToEntityMapper::class
    factoryOf(::TrackDataToEntityMapperImpl) bind TrackDataToEntityMapper::class

    factoryOf(::TrackSimplifiedOutputToDataMapperImpl) bind TrackSimplifiedOutputToDataMapper::class
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class

    factoryOf(::GetRecommendationsParamsToRequestMapperImpl) bind GetRecommendationsParamsToRequestMapper::class
    factoryOf(::GetRecommendationsResponseToResultMapperImpl) bind GetRecommendationsResponseToResultMapper::class
    factoryOf(::GetTrackParamsToRequestMapperImpl) bind GetTrackParamsToRequestMapper::class
    factoryOf(::GetTrackResponseToResultMapperImpl) bind GetTrackResponseToResultMapper::class
}