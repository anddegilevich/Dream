package and.degilevich.dream.shared.feature.album.source.impl.di

import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.impl.remote.AlbumRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumSourceModule() = module {
    singleOf(::AlbumRemoteDataSourceImpl) bind AlbumRemoteDataSource::class
    includes(albumSourceMapperModule())
}