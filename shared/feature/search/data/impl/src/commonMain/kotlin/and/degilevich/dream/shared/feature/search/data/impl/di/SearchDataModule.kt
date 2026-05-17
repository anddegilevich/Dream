package and.degilevich.dream.shared.feature.search.data.impl.di

import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.data.impl.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.data.impl.remote.SearchRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.search.data.impl.repository.SearchRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchDataModule() = module {
    singleOf(::SearchRemoteDataSourceImpl) bind SearchRemoteDataSource::class
    singleOf(::SearchRepositoryImpl) bind SearchRepository::class
}