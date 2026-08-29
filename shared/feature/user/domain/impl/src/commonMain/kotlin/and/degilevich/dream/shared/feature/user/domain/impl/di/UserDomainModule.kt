package and.degilevich.dream.shared.feature.user.domain.impl.di

import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.domain.impl.usecase.GetCurrentUserUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userDomainModule() = module {
    factoryOf(::GetCurrentUserUseCaseImpl) bind GetCurrentUserUseCase::class
}
