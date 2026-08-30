package and.degilevich.dream.shared.feature.playlist.data.impl.di

import and.degilevich.dream.shared.feature.playlist.data.api.repository.PlaylistRepository
import and.degilevich.dream.shared.feature.playlist.data.impl.remote.PlaylistRemoteDataSource
import and.degilevich.dream.shared.feature.playlist.data.impl.remote.PlaylistRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.playlist.data.impl.repository.PlaylistRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDataModule() = module {
    singleOf(::PlaylistRemoteDataSourceImpl) bind PlaylistRemoteDataSource::class
    singleOf(::PlaylistRepositoryImpl) bind PlaylistRepository::class
}
