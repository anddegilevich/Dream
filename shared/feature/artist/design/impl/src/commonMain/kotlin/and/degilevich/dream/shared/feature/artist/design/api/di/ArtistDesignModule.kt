package and.degilevich.dream.shared.feature.artist.design.api.di

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistCardUIStateMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistCardUIStateMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDesignModule() = module {
    factoryOf(::ArtistCardUIStateMapperImpl) bind ArtistCardUIStateMapper::class
}