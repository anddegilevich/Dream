package and.degilevich.dream.shared.feature.artist.source.impl.di

import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.source.api.local.mapper.ArtistEntityToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.source.impl.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.source.impl.local.mapper.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.local.mapper.ArtistEntityToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.ArtistRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.ArtistFollowersOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.ArtistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.ArtistSimplifiedOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistAlbumsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistAlbumsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistSourceModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class

    // Mapper
    factoryOf(::ArtistSimplifiedOutputToDataMapperImpl) bind ArtistSimplifiedOutputToDataMapper::class
    factoryOf(::ArtistOutputToDataMapperImpl) bind ArtistOutputToDataMapper::class
    factoryOf(::ArtistEntityToDataMapperImpl) bind ArtistEntityToDataMapper::class

    factoryOf(::ArtistDataToEntityMapperImpl) bind ArtistDataToEntityMapper::class
    factoryOf(::ArtistFollowersOutputToDataMapperImpl) bind ArtistFollowersOutputToDataMapper::class

    factoryOf(::GetArtistParamsToRequestMapperImpl) bind GetArtistParamsToRequestMapper::class
    factoryOf(::GetArtistResponseToResultMapperImpl) bind GetArtistResponseToResultMapper::class

    factoryOf(::GetArtistsParamsToRequestMapperImpl) bind GetArtistsParamsToRequestMapper::class
    factoryOf(::GetArtistsResponseToResultMapperImpl) bind GetArtistsResponseToResultMapper::class

    factoryOf(
        ::GetArtistTopTracksParamsToRequestMapperImpl
    ) bind GetArtistTopTracksParamsToRequestMapper::class
    factoryOf(
        ::GetArtistTopTracksResponseToResultMapperImpl
    ) bind GetArtistTopTracksResponseToResultMapper::class

    factoryOf(
        ::GetArtistRelatedArtistsParamsToRequestMapperImpl
    ) bind GetArtistRelatedArtistsParamsToRequestMapper::class
    factoryOf(
        ::GetArtistRelatedArtistsResponseToResultMapperImpl
    ) bind GetArtistRelatedArtistsResponseToResultMapper::class

    factoryOf(::GetArtistAlbumsParamsToRequestMapperImpl) bind GetArtistAlbumsParamsToRequestMapper::class
    factoryOf(
        ::GetArtistAlbumsResponseToResultMapperImpl
    ) bind GetArtistAlbumsResponseToResultMapper::class
}