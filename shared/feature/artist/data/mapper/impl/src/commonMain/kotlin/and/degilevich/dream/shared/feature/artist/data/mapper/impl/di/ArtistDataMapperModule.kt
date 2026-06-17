package and.degilevich.dream.shared.feature.artist.data.mapper.impl.di

import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.local.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.local.SimplifiedArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.ArtistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.GetArtistAlbumsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.SimplifiedArtistOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDataMapperModule() = module {
    factoryOf(::SimplifiedArtistOutputToDataMapperImpl) bind SimplifiedArtistOutputToDataMapper::class
    factoryOf(::ArtistOutputToDataMapperImpl) bind ArtistOutputToDataMapper::class

    factoryOf(::ArtistDataToEntityMapperImpl) bind ArtistDataToEntityMapper::class
    factoryOf(::SimplifiedArtistDataToEntityMapperImpl) bind SimplifiedArtistDataToEntityMapper::class

    factoryOf(::GetArtistAlbumsResponseToResultMapperImpl) bind GetArtistAlbumsResponseToResultMapper::class
}
