package and.degilevich.dream.shared.feature.artist.core.impl.di

import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.impl.source.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.ArtistRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistResponseToResultMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistsParamsToRequestMapper
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.mappers.GetArtistsResponseToResultMapper
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun artistSourceModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class

    factoryOf(::GetArtistParamsToRequestMapper)
    factoryOf(::GetArtistResponseToResultMapper)
    factoryOf(::GetArtistsParamsToRequestMapper)
    factoryOf(::GetArtistsResponseToResultMapper)
}