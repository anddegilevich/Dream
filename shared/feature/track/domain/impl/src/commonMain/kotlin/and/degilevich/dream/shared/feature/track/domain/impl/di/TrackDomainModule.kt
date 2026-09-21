package and.degilevich.dream.shared.feature.track.domain.impl.di

import and.degilevich.dream.shared.feature.track.domain.api.paging.LikedTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetSavedTracksUseCase
import and.degilevich.dream.shared.feature.track.domain.api.usecase.GetTrackUseCase
import and.degilevich.dream.shared.feature.track.domain.impl.paging.LikedTracksPagingSourceFactoryImpl
import and.degilevich.dream.shared.feature.track.domain.impl.usecase.GetSavedTracksUseCaseImpl
import and.degilevich.dream.shared.feature.track.domain.impl.usecase.GetTrackUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDomainModule() = module {
    factoryOf(::GetTrackUseCaseImpl) bind GetTrackUseCase::class
    factoryOf(::GetSavedTracksUseCaseImpl) bind GetSavedTracksUseCase::class
    factoryOf(::LikedTracksPagingSourceFactoryImpl) bind LikedTracksPagingSourceFactory::class
}
