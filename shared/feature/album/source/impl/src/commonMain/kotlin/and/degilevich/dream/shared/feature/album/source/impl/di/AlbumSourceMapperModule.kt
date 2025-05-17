package and.degilevich.dream.shared.feature.album.source.impl.di

import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetAlbumResponseToResultMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesParamsToRequestMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.GetNewReleasesResponseToResultMapper
import and.degilevich.dream.shared.feature.album.source.impl.remote.mapper.NewReleasesAlbumsOutputToDataMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal fun albumSourceMapperModule() = module {
    factoryOf(::GetAlbumParamsToRequestMapper)
    factoryOf(::GetAlbumResponseToResultMapper)

    factoryOf(::GetNewReleasesParamsToRequestMapper)
    factoryOf(::GetNewReleasesResponseToResultMapper)
    factoryOf(::NewReleasesAlbumsOutputToDataMapper)
}