package and.degilevich.dream.shared.feature.track.data.impl.di

import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository
import and.degilevich.dream.shared.feature.track.data.impl.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.data.impl.local.TrackLocalDataSourceImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.data.impl.remote.TrackRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.track.data.impl.repository.TrackRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDataModule() = module {
    singleOf(::TrackRemoteDataSourceImpl) bind TrackRemoteDataSource::class
    singleOf(::TrackLocalDataSourceImpl) bind TrackLocalDataSource::class
    singleOf(::TrackRepositoryImpl) bind TrackRepository::class
}