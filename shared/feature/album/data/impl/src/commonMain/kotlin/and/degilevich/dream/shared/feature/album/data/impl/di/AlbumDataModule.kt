package and.degilevich.dream.shared.feature.album.data.impl.di

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.album.data.impl.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.data.impl.local.AlbumLocalDataSourceImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.data.impl.remote.AlbumRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.album.data.impl.repository.AlbumRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDataModule() = module {
    singleOf(::AlbumRemoteDataSourceImpl) bind AlbumRemoteDataSource::class
    singleOf(::AlbumLocalDataSourceImpl) bind AlbumLocalDataSource::class
    singleOf(::AlbumRepositoryImpl) bind AlbumRepository::class
}