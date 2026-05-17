package and.degilevich.dream.shared.feature.artist.data.impl.di

import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.artist.data.impl.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.impl.local.ArtistLocalDataSourceImpl
import and.degilevich.dream.shared.feature.artist.data.impl.remote.ArtistRemoteDataSource
import and.degilevich.dream.shared.feature.artist.data.impl.remote.ArtistRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.artist.data.impl.repository.ArtistRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun artistDataModule() = module {
    singleOf(::ArtistRemoteDataSourceImpl) bind ArtistRemoteDataSource::class
    singleOf(::ArtistLocalDataSourceImpl) bind ArtistLocalDataSource::class
    singleOf(::ArtistRepositoryImpl) bind ArtistRepository::class
}