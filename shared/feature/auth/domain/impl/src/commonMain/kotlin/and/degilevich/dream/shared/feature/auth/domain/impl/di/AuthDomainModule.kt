package and.degilevich.dream.shared.feature.auth.domain.impl.di

import and.degilevich.dream.shared.feature.auth.domain.api.usecase.HasActiveSessionUseCase
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LoginUseCase
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.LogoutUseCase
import and.degilevich.dream.shared.feature.auth.domain.api.usecase.ObserveHasActiveSessionUseCase
import and.degilevich.dream.shared.feature.auth.domain.impl.usecase.HasActiveSessionUseCaseImpl
import and.degilevich.dream.shared.feature.auth.domain.impl.usecase.LoginUseCaseImpl
import and.degilevich.dream.shared.feature.auth.domain.impl.usecase.LogoutUseCaseImpl
import and.degilevich.dream.shared.feature.auth.domain.impl.usecase.ObserveHasActiveSessionUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun authDomainModule() = module {
    factoryOf(::LoginUseCaseImpl) bind LoginUseCase::class
    factoryOf(::LogoutUseCaseImpl) bind LogoutUseCase::class
    factoryOf(::HasActiveSessionUseCaseImpl) bind HasActiveSessionUseCase::class
    factoryOf(::ObserveHasActiveSessionUseCaseImpl) bind ObserveHasActiveSessionUseCase::class
}
