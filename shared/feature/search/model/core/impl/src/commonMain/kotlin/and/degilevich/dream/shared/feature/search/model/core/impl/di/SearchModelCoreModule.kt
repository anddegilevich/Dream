package and.degilevich.dream.shared.feature.search.model.core.impl.di

import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.model.core.api.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.model.core.impl.mapper.SearchParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.search.model.core.impl.mapper.SearchResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchModelCoreModule() = module {
    factoryOf(::SearchParamsToRequestMapperImpl) bind SearchParamsToRequestMapper::class
    factoryOf(::SearchResponseToResultMapperImpl) bind SearchResponseToResultMapper::class
}