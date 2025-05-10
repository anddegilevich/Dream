package and.degilevich.dream.shared.feature.track.source.impl.di

import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetRecommendationsResponseToResultMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackParamsToRequestMapper
import and.degilevich.dream.shared.feature.track.source.impl.remote.mapper.GetTrackResponseToResultMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal fun trackSourceMapperModule() = module {
    factoryOf(::GetRecommendationsParamsToRequestMapper)
    factoryOf(::GetRecommendationsResponseToResultMapper)

    factoryOf(::GetTrackParamsToRequestMapper)
    factoryOf(::GetTrackResponseToResultMapper)
}