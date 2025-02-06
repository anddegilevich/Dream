package and.degilevich.dream.shared.feature.artist.core.impl.di

import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.api.domain.usecase.GetArtistsFlowUseCase
import and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase.GetArtistFlowUseCaseImpl
import and.degilevich.dream.shared.feature.artist.core.impl.domain.usecase.GetArtistsFlowUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun artistDomainModule() = module {
    factoryOf(::GetArtistsFlowUseCaseImpl) bind GetArtistsFlowUseCase::class
    factoryOf(::GetArtistFlowUseCaseImpl) bind GetArtistFlowUseCase::class
}