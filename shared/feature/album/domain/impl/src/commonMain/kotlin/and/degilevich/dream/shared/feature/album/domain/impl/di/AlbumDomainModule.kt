package and.degilevich.dream.shared.feature.album.domain.impl.di

import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchAlbumUseCase
import and.degilevich.dream.shared.feature.album.domain.api.usecase.FetchNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.domain.impl.usecase.FetchAlbumUseCaseImpl
import and.degilevich.dream.shared.feature.album.domain.impl.usecase.FetchNewReleasesUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDomainModule() = module {
    factoryOf(::FetchAlbumUseCaseImpl) bind FetchAlbumUseCase::class
    factoryOf(::FetchNewReleasesUseCaseImpl) bind FetchNewReleasesUseCase::class
}