package and.degilevich.dream.shared.feature.album.model.artifact.impl.di

import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.impl.mapper.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.model.artifact.impl.mapper.AlbumTracksOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumModelArtifactModule() = module {
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
}