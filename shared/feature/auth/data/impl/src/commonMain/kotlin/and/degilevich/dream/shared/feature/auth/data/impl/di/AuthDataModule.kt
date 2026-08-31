package and.degilevich.dream.shared.feature.auth.data.impl.di

import and.degilevich.dream.shared.feature.auth.data.api.repository.AuthRepository
import and.degilevich.dream.shared.feature.auth.data.impl.repository.AuthRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun authDataModule() = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}
