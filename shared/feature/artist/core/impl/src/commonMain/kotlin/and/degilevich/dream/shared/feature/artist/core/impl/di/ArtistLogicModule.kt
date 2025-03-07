package and.degilevich.dream.shared.feature.artist.core.impl.di

import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.logic.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.impl.logic.usecase.GetArtistFlowUseCaseImpl
import and.degilevich.dream.shared.feature.artist.core.impl.logic.usecase.GetArtistsFlowUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun artistLogicModule() = module {
    factoryOf(::GetArtistsFlowUseCaseImpl) bind GetArtistsFlowUseCase::class
    factoryOf(::GetArtistFlowUseCaseImpl) bind GetArtistFlowUseCase::class
}