package and.degilevich.dream.shared.feature.playlist.domain.impl.di

import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetCurrentUserPlaylistsUseCase
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistTracksUseCase
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistUseCase
import and.degilevich.dream.shared.feature.playlist.domain.impl.paging.PlaylistTracksPagingSourceFactoryImpl
import and.degilevich.dream.shared.feature.playlist.domain.impl.usecase.GetCurrentUserPlaylistsUseCaseImpl
import and.degilevich.dream.shared.feature.playlist.domain.impl.usecase.GetPlaylistTracksUseCaseImpl
import and.degilevich.dream.shared.feature.playlist.domain.impl.usecase.GetPlaylistUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDomainModule() = module {
    factoryOf(::GetCurrentUserPlaylistsUseCaseImpl) bind GetCurrentUserPlaylistsUseCase::class
    factoryOf(::GetPlaylistUseCaseImpl) bind GetPlaylistUseCase::class
    factoryOf(::GetPlaylistTracksUseCaseImpl) bind GetPlaylistTracksUseCase::class
    factoryOf(::PlaylistTracksPagingSourceFactoryImpl) bind PlaylistTracksPagingSourceFactory::class
}
