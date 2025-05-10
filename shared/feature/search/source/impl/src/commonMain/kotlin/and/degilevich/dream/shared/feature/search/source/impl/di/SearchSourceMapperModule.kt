package and.degilevich.dream.shared.feature.search.source.impl.di

import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchResponseToResultMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun searchSourceMapperModule() = module {
    factoryOf(::SearchParamsToRequestMapper)
    factoryOf(::SearchResponseToResultMapper)
}