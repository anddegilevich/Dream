package and.degilevich.dream.shared.feature.user.domain.impl.di

import and.degilevich.dream.shared.feature.user.domain.api.manager.UserFetchingManager
import and.degilevich.dream.shared.feature.user.domain.api.usecase.GetCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.domain.api.usecase.ObserveCurrentUserUseCase
import and.degilevich.dream.shared.feature.user.domain.impl.manager.UserFetchingManagerImpl
import and.degilevich.dream.shared.feature.user.domain.impl.usecase.GetCurrentUserUseCaseImpl
import and.degilevich.dream.shared.feature.user.domain.impl.usecase.ObserveCurrentUserUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userDomainModule() = module {
    factoryOf(::GetCurrentUserUseCaseImpl) bind GetCurrentUserUseCase::class
    factoryOf(::ObserveCurrentUserUseCaseImpl) bind ObserveCurrentUserUseCase::class
    single<UserFetchingManager> {
        UserFetchingManagerImpl(
            getCurrentUserUseCase = get(),
            userRepository = get()
        )
    }
}
