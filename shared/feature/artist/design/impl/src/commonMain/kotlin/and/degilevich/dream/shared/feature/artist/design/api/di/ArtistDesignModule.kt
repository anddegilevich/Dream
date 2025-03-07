package and.degilevich.dream.shared.feature.artist.design.api.di

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistUIItemMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistUIItemMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDesignModule() = module {
    factoryOf(::ArtistUIItemMapperImpl) bind ArtistUIItemMapper::class
}