package and.degilevich.dream.shared.feature.artist.data.impl.di

import and.degilevich.dream.shared.feature.artist.data.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.api.local.mapper.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.api.local.mapper.ArtistSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.ArtistSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistAlbumsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistAlbumsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.data.api.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.data.impl.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.data.impl.local.mapper.ArtistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.local.mapper.ArtistSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.ArtistRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.ArtistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.ArtistSimplifiedOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.GetArtistAlbumsParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.GetArtistAlbumsResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.GetArtistParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.mapper.GetArtistResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDataModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class

    // Mapper
    factoryOf(::ArtistSimplifiedOutputToDataMapperImpl) bind ArtistSimplifiedOutputToDataMapper::class
    factoryOf(::ArtistOutputToDataMapperImpl) bind ArtistOutputToDataMapper::class

    factoryOf(::ArtistDataToEntityMapperImpl) bind ArtistDataToEntityMapper::class
    factoryOf(::ArtistSimplifiedDataToEntityMapperImpl) bind ArtistSimplifiedDataToEntityMapper::class

    factoryOf(::GetArtistParamsToRequestMapperImpl) bind GetArtistParamsToRequestMapper::class
    factoryOf(::GetArtistResponseToResultMapperImpl) bind GetArtistResponseToResultMapper::class

    factoryOf(::GetArtistAlbumsParamsToRequestMapperImpl) bind GetArtistAlbumsParamsToRequestMapper::class
    factoryOf(::GetArtistAlbumsResponseToResultMapperImpl) bind GetArtistAlbumsResponseToResultMapper::class
}