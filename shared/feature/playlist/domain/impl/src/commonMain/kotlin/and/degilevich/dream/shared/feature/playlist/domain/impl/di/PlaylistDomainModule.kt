package and.degilevich.dream.shared.feature.playlist.domain.impl.di

import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetCurrentUserPlaylistsUseCase
import and.degilevich.dream.shared.feature.playlist.domain.impl.usecase.GetCurrentUserPlaylistsUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDomainModule() = module {
    factoryOf(::GetCurrentUserPlaylistsUseCaseImpl) bind GetCurrentUserPlaylistsUseCase::class
}
