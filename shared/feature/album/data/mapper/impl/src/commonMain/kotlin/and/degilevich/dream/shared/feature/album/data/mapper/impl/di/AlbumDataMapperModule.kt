package and.degilevich.dream.shared.feature.album.data.mapper.impl.di

import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.impl.local.AlbumDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.local.SimplifiedAlbumDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.AlbumTracksOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.SimplifiedAlbumOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDataMapperModule() = module {
    factoryOf(::AlbumDataToEntityMapperImpl) bind AlbumDataToEntityMapper::class
    factoryOf(::SimplifiedAlbumDataToEntityMapperImpl) bind SimplifiedAlbumDataToEntityMapper::class
    factoryOf(::SimplifiedAlbumOutputToDataMapperImpl) bind SimplifiedAlbumOutputToDataMapper::class
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
}
