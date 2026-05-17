package and.degilevich.dream.shared.feature.artist.domain.impl.di

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.GetArtistsUseCase
import and.degilevich.dream.shared.feature.artist.domain.usecase.GetArtistAlbumsUseCaseImpl
import and.degilevich.dream.shared.feature.artist.domain.usecase.GetArtistUseCaseImpl
import and.degilevich.dream.shared.feature.artist.domain.usecase.GetArtistsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDomainModule() = module {
    factoryOf(::GetArtistsUseCaseImpl) bind GetArtistsUseCase::class
    factoryOf(::GetArtistUseCaseImpl) bind GetArtistUseCase::class
    factoryOf(::GetArtistAlbumsUseCaseImpl) bind GetArtistAlbumsUseCase::class
}