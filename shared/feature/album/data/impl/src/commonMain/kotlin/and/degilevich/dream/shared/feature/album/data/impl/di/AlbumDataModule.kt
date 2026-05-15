package and.degilevich.dream.shared.feature.album.data.impl.di

import and.degilevich.dream.shared.feature.album.data.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.album.data.api.local.mapper.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.api.local.mapper.AlbumSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.api.remote.AlbumRemoteDataSource
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.data.api.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.data.impl.local.AlbumLocalDataSourceImpl
import and.degilevich.dream.shared.feature.album.data.impl.local.mapper.AlbumDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.local.mapper.AlbumSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.AlbumRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.mapper.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.mapper.AlbumSimplifiedOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.mapper.AlbumTracksOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.mapper.GetAlbumParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.data.impl.remote.mapper.GetAlbumResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDataModule() = module {
    singleOf(::AlbumRemoteDataSourceImpl) bind AlbumRemoteDataSource::class
    singleOf(::AlbumLocalDataSourceImpl) bind AlbumLocalDataSource::class

    // Mapper
    factoryOf(::AlbumDataToEntityMapperImpl) bind AlbumDataToEntityMapper::class
    factoryOf(::AlbumSimplifiedDataToEntityMapperImpl) bind AlbumSimplifiedDataToEntityMapper::class

    factoryOf(::AlbumSimplifiedOutputToDataMapperImpl) bind AlbumSimplifiedOutputToDataMapper::class
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
    factoryOf(::GetAlbumParamsToRequestMapperImpl) bind GetAlbumParamsToRequestMapper::class
    factoryOf(::GetAlbumResponseToResultMapperImpl) bind GetAlbumResponseToResultMapper::class
}