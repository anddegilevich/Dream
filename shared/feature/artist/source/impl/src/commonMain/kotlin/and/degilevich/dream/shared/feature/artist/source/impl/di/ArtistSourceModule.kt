package and.degilevich.dream.shared.feature.artist.source.impl.di

import and.degilevich.dream.shared.feature.artist.source.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.source.api.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.source.impl.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.source.impl.remote.ArtistRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistSourceModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class
    includes(artistSourceMapperModule())
}