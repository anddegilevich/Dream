package and.degilevich.dream.shared.feature.artist.source.impl.di

import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistRelatedArtistsResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistTopTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.source.impl.remote.mapper.GetArtistsResponseToResultMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal fun artistSourceMapperModule() = module {
    factoryOf(::GetArtistParamsToRequestMapper)
    factoryOf(::GetArtistResponseToResultMapper)

    factoryOf(::GetArtistsParamsToRequestMapper)
    factoryOf(::GetArtistsResponseToResultMapper)

    factoryOf(::GetArtistTopTracksParamsToRequestMapper)
    factoryOf(::GetArtistTopTracksResponseToResultMapper)

    factoryOf(::GetArtistRelatedArtistsParamsToRequestMapper)
    factoryOf(::GetArtistRelatedArtistsResponseToResultMapper)
}