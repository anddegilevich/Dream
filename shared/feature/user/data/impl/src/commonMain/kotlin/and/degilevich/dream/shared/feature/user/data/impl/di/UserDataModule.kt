package and.degilevich.dream.shared.feature.user.data.impl.di

import and.degilevich.dream.shared.feature.user.data.api.repository.UserRepository
import and.degilevich.dream.shared.feature.user.data.impl.remote.UserRemoteDataSource
import and.degilevich.dream.shared.feature.user.data.impl.remote.UserRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.user.data.impl.repository.UserRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userDataModule() = module {
    singleOf(::UserRemoteDataSourceImpl) bind UserRemoteDataSource::class
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}
