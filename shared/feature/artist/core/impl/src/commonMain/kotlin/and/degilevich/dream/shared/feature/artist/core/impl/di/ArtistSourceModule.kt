package and.degilevich.dream.shared.feature.artist.core.impl.di

import and.degilevich.dream.shared.feature.artist.core.api.source.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.core.api.source.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.core.impl.source.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.core.impl.source.remote.ArtistRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal fun artistSourceModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class
}