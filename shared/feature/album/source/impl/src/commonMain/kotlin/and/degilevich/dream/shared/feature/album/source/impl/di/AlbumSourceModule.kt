package and.degilevich.dream.shared.feature.album.source.impl.di

import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetNewReleasesParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.GetNewReleasesResponseToResultMapper
import and.degilevich.dream.shared.feature.album.source.api.remote.mapper.NewReleasesAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.AlbumTracksOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.NewReleasesAlbumsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.source.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.source.impl.remote.AlbumRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.AlbumSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumSourceModule() = module {
    singleOf(::AlbumRemoteDataSourceImpl) bind AlbumRemoteDataSource::class

    // Mapper
    factoryOf(::AlbumSimplifiedOutputToDataMapperImpl) bind AlbumSimplifiedOutputToDataMapper::class
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
    factoryOf(::NewReleasesAlbumsOutputToDataMapperImpl) bind NewReleasesAlbumsOutputToDataMapper::class
    factoryOf(::GetAlbumParamsToRequestMapperImpl) bind GetAlbumParamsToRequestMapper::class
    factoryOf(::GetAlbumResponseToResultMapperImpl) bind GetAlbumResponseToResultMapper::class
    factoryOf(::GetNewReleasesParamsToRequestMapperImpl) bind GetNewReleasesParamsToRequestMapper::class
    factoryOf(::GetNewReleasesResponseToResultMapperImpl) bind GetNewReleasesResponseToResultMapper::class
}