package and.degilevich.dream.shared.feature.track.model.core.impl.di

import and.degilevich.dream.shared.feature.track.model.core.api.mapper.TrackOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.TrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.model.core.api.mapper.GetTrackResponseToResultMapper
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.GetRecommendationsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.GetRecommendationsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.GetTrackParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.track.model.core.impl.mapper.GetTrackResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackModelCoreModule() = module {
    factoryOf(::TrackOutputToDataMapperImpl) bind TrackOutputToDataMapper::class

    factoryOf(::GetRecommendationsParamsToRequestMapperImpl) bind GetRecommendationsParamsToRequestMapper::class
    factoryOf(::GetRecommendationsResponseToResultMapperImpl) bind GetRecommendationsResponseToResultMapper::class
    factoryOf(::GetTrackParamsToRequestMapperImpl) bind GetTrackParamsToRequestMapper::class
    factoryOf(::GetTrackResponseToResultMapperImpl) bind GetTrackResponseToResultMapper::class
}