package and.degilevich.dream.shared.feature.album.model.artifact.impl.di

import and.degilevich.dream.shared.feature.album.model.artifact.api.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.impl.mapper.AlbumSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumModelArtifactModule() = module {
    factoryOf(::AlbumSimplifiedOutputToDataMapperImpl) bind AlbumSimplifiedOutputToDataMapper::class
}