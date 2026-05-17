package and.degilevich.dream.shared.feature.album.data.impl.di

import and.degilevich.dream.shared.feature.album.data.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.data.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.data.impl.local.AlbumLocalDataSourceImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.AlbumRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDataModule() = module {
    singleOf(::AlbumRemoteDataSourceImpl) bind AlbumRemoteDataSource::class
    singleOf(::AlbumLocalDataSourceImpl) bind AlbumLocalDataSource::class
}