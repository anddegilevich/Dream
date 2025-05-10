package and.degilevich.dream.shared.feature.search.source.impl.di

import and.degilevich.dream.shared.feature.search.source.api.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.source.impl.remote.SearchRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchSourceModule() = module {
    singleOf(::SearchRemoteDataSourceImpl) bind SearchRemoteDataSource::class
    includes(searchSourceMapperModule())
}