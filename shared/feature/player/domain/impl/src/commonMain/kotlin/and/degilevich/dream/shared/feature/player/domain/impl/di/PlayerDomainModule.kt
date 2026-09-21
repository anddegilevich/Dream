package and.degilevich.dream.shared.feature.player.domain.impl.di

import and.degilevich.dream.shared.feature.player.domain.api.usecase.GetRecentlyPlayedUseCase
import and.degilevich.dream.shared.feature.player.domain.impl.usecase.GetRecentlyPlayedUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerDomainModule() = module {
    factoryOf(::GetRecentlyPlayedUseCaseImpl) bind GetRecentlyPlayedUseCase::class
}
