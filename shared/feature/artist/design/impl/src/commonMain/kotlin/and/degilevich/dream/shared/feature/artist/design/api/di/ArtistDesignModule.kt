package and.degilevich.dream.shared.feature.artist.design.api.di

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToCardUIDataMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDesignModule() = module {
    factoryOf(::ArtistDataToCardUIDataMapperImpl) bind ArtistDataToCardUIDataMapper::class
}