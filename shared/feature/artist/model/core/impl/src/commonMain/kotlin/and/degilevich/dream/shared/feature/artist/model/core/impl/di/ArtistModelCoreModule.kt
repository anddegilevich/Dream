package and.degilevich.dream.shared.feature.artist.model.core.impl.di

import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistEntityToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistEntityToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistFollowersOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistModelCoreModule() = module {
    factoryOf(::ArtistOutputToDataMapperImpl) bind ArtistOutputToDataMapper::class
    factoryOf(::ArtistEntityToDataMapperImpl) bind ArtistEntityToDataMapper::class
    factoryOf(::ArtistDataToEntityMapperImpl) bind ArtistDataToEntityMapper::class
    factoryOf(::ArtistFollowersOutputToDataMapperImpl) bind ArtistFollowersOutputToDataMapper::class
}