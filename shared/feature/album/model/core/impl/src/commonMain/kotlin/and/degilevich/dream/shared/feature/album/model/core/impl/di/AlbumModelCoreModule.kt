package and.degilevich.dream.shared.feature.album.model.core.impl.di

import and.degilevich.dream.shared.feature.album.model.core.api.data.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.AlbumTracksOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumModelCoreModule() = module {
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
}