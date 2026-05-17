package and.degilevich.dream.shared.feature.album.domain.impl.di

import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetAlbumUseCase
import and.degilevich.dream.shared.feature.album.domain.api.usecase.GetNewReleasesUseCase
import and.degilevich.dream.shared.feature.album.domain.impl.usecase.GetAlbumUseCaseImpl
import and.degilevich.dream.shared.feature.album.domain.impl.usecase.GetNewReleasesUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDomainModule() = module {
    factoryOf(::GetAlbumUseCaseImpl) bind GetAlbumUseCase::class
    factoryOf(::GetNewReleasesUseCaseImpl) bind GetNewReleasesUseCase::class
}