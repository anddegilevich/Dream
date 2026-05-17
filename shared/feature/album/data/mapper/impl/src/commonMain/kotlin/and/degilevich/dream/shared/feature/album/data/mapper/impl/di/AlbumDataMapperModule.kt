package and.degilevich.dream.shared.feature.album.data.mapper.impl.di

import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumSimplifiedDataToEntityMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.data.mapper.impl.local.AlbumDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.local.AlbumSimplifiedDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.AlbumSimplifiedOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.AlbumTracksOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.GetAlbumParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.data.mapper.impl.remote.GetAlbumResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDataMapperModule() = module {
    factoryOf(::AlbumDataToEntityMapperImpl) bind AlbumDataToEntityMapper::class
    factoryOf(::AlbumSimplifiedDataToEntityMapperImpl) bind AlbumSimplifiedDataToEntityMapper::class
    factoryOf(::AlbumSimplifiedOutputToDataMapperImpl) bind AlbumSimplifiedOutputToDataMapper::class
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
    factoryOf(::GetAlbumParamsToRequestMapperImpl) bind GetAlbumParamsToRequestMapper::class
    factoryOf(::GetAlbumResponseToResultMapperImpl) bind GetAlbumResponseToResultMapper::class
}
