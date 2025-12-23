package and.degilevich.dream.shared.feature.category.source.impl.di

import and.degilevich.dream.shared.feature.category.source.api.remote.CategoryRemoteDataSource
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.CategoryOutputToDataMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesParamsToRequestMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoriesResponseToResultMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryParamsToRequestMapper
import and.degilevich.dream.shared.feature.category.source.api.remote.mapper.GetCategoryResponseToResultMapper
import and.degilevich.dream.shared.feature.category.source.impl.remote.CategoryRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.category.source.impl.remote.mapper.CategoryOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.category.source.impl.remote.mapper.GetCategoriesParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.category.source.impl.remote.mapper.GetCategoriesResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.category.source.impl.remote.mapper.GetCategoryParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.category.source.impl.remote.mapper.GetCategoryResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun categorySourceModule() = module {
    singleOf(::CategoryRemoteDataSourceImpl) bind CategoryRemoteDataSource::class

    // Mapper
    factoryOf(::CategoryOutputToDataMapperImpl) bind CategoryOutputToDataMapper::class

    factoryOf(::GetCategoriesParamsToRequestMapperImpl) bind GetCategoriesParamsToRequestMapper::class
    factoryOf(::GetCategoriesResponseToResultMapperImpl) bind GetCategoriesResponseToResultMapper::class

    factoryOf(::GetCategoryParamsToRequestMapperImpl) bind GetCategoryParamsToRequestMapper::class
    factoryOf(::GetCategoryResponseToResultMapperImpl) bind GetCategoryResponseToResultMapper::class
}