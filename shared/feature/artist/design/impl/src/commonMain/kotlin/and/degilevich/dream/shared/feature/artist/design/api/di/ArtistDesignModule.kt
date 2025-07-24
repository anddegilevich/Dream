package and.degilevich.dream.shared.feature.artist.design.api.di

import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToLabelUIDataMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToLabelUIDataMapperImpl
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistsInfoToStringMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDesignModule() = module {
    factoryOf(::ArtistDataToLabelUIDataMapperImpl) bind ArtistDataToLabelUIDataMapper::class
    factoryOf(::ArtistsInfoToStringMapperImpl) bind ArtistsInfoToStringMapper::class
}