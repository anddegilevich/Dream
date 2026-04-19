package and.degilevich.dream.shared.feature.artist.domain.impl.di

import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistAlbumsUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistUseCase
import and.degilevich.dream.shared.feature.artist.domain.api.usecase.FetchArtistsUseCase
import and.degilevich.dream.shared.feature.artist.domain.usecase.FetchArtistAlbumsUseCaseImpl
import and.degilevich.dream.shared.feature.artist.domain.usecase.FetchArtistUseCaseImpl
import and.degilevich.dream.shared.feature.artist.domain.usecase.FetchArtistsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDomainModule() = module {
    factoryOf(::FetchArtistsUseCaseImpl) bind FetchArtistsUseCase::class
    factoryOf(::FetchArtistUseCaseImpl) bind FetchArtistUseCase::class
    factoryOf(::FetchArtistAlbumsUseCaseImpl) bind FetchArtistAlbumsUseCase::class
}