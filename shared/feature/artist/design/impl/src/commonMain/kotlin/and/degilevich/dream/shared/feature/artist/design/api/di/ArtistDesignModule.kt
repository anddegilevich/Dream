package and.degilevich.dream.shared.feature.artist.design.api.di

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistCardUIDataMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDesignModule() = module {
    factoryOf(::ArtistCardUIDataMapperImpl) bind ArtistCardUIDataMapper::class
}