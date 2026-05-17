package and.degilevich.dream.shared.feature.artist.data.mapper.impl.di

import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.local.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.local.ArtistSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.ArtistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.ArtistSimplifiedOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.GetArtistAlbumsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.GetArtistAlbumsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.GetArtistParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.data.mapper.impl.remote.GetArtistResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDataMapperModule() = module {
    factoryOf(::ArtistSimplifiedOutputToDataMapperImpl) bind ArtistSimplifiedOutputToDataMapper::class
    factoryOf(::ArtistOutputToDataMapperImpl) bind ArtistOutputToDataMapper::class

    factoryOf(::ArtistDataToEntityMapperImpl) bind ArtistDataToEntityMapper::class
    factoryOf(::ArtistSimplifiedDataToEntityMapperImpl) bind ArtistSimplifiedDataToEntityMapper::class

    factoryOf(::GetArtistParamsToRequestMapperImpl) bind GetArtistParamsToRequestMapper::class
    factoryOf(::GetArtistResponseToResultMapperImpl) bind GetArtistResponseToResultMapper::class

    factoryOf(::GetArtistAlbumsParamsToRequestMapperImpl) bind GetArtistAlbumsParamsToRequestMapper::class
    factoryOf(::GetArtistAlbumsResponseToResultMapperImpl) bind GetArtistAlbumsResponseToResultMapper::class
}
