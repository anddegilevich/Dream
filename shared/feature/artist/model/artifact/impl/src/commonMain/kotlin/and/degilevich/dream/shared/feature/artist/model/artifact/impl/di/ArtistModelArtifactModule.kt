package and.degilevich.dream.shared.feature.artist.model.artifact.impl.di

import and.degilevich.dream.shared.feature.artist.model.artifact.api.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.impl.mapper.ArtistSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistModelArtifactModule() = module {
    factoryOf(::ArtistSimplifiedOutputToDataMapperImpl) bind ArtistSimplifiedOutputToDataMapper::class
}