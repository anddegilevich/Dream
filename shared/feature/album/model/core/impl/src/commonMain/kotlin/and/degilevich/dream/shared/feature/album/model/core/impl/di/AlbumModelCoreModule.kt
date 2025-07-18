package and.degilevich.dream.shared.feature.album.model.core.impl.di

import and.degilevich.dream.shared.feature.album.model.core.api.mapper.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetNewReleasesParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.GetNewReleasesResponseToResultMapper
import and.degilevich.dream.shared.feature.album.model.core.api.mapper.NewReleasesAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.AlbumOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.AlbumTracksOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.GetAlbumParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.GetAlbumResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.GetNewReleasesParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.GetNewReleasesResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.album.model.core.impl.mapper.NewReleasesAlbumsOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumModelCoreModule() = module {
    factoryOf(::AlbumOutputToDataMapperImpl) bind AlbumOutputToDataMapper::class
    factoryOf(::AlbumTracksOutputToDataMapperImpl) bind AlbumTracksOutputToDataMapper::class
    factoryOf(::NewReleasesAlbumsOutputToDataMapperImpl) bind NewReleasesAlbumsOutputToDataMapper::class

    factoryOf(::GetAlbumParamsToRequestMapperImpl) bind GetAlbumParamsToRequestMapper::class
    factoryOf(::GetAlbumResponseToResultMapperImpl) bind GetAlbumResponseToResultMapper::class
    factoryOf(::GetNewReleasesParamsToRequestMapperImpl) bind GetNewReleasesParamsToRequestMapper::class
    factoryOf(::GetNewReleasesResponseToResultMapperImpl) bind GetNewReleasesResponseToResultMapper::class
}