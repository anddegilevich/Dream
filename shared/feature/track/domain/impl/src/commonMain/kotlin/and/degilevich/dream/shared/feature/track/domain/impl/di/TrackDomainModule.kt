package and.degilevich.dream.shared.feature.track.domain.impl.di

import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetTrackUseCase
import and.degilevich.dream.shared.feature.track.domain.impl.usecase.GetTrackUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDomainModule() = module {
    factoryOf(::GetTrackUseCaseImpl) bind GetTrackUseCase::class
}