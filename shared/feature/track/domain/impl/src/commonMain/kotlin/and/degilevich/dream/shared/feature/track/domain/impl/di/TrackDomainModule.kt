package and.degilevich.dream.shared.feature.track.domain.impl.di

import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchRecommendationsUseCase
import and.degilevich.dream.shared.feature.track.domain.api.usecase.FetchTrackUseCase
import and.degilevich.dream.shared.feature.track.domain.impl.usecase.FetchRecommendationsUseCaseImpl
import and.degilevich.dream.shared.feature.track.domain.impl.usecase.FetchTrackUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDomainModule() = module {
    factoryOf(::FetchTrackUseCaseImpl) bind FetchTrackUseCase::class
    factoryOf(::FetchRecommendationsUseCaseImpl) bind FetchRecommendationsUseCase::class
}