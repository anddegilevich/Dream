package and.degilevich.dream.shared.feature.artist.model.core.impl.di

import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistEntityToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistFollowersOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.mapper.GetArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistEntityToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistFollowersOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.ArtistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistRelatedArtistsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistRelatedArtistsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistTopTracksParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistTopTracksResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.model.core.impl.mapper.GetArtistsResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistModelCoreModule() = module {
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
}