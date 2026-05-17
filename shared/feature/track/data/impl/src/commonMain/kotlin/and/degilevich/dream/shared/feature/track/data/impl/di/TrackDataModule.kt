package and.degilevich.dream.shared.feature.track.data.impl.di

import and.degilevich.dream.shared.feature.track.data.api.local.TrackLocalDataSource
import and.degilevich.dream.shared.feature.track.data.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.data.impl.local.TrackLocalDataSourceImpl
import and.degilevich.dream.shared.feature.track.data.impl.remote.TrackRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackDataModule() = module {
    singleOf(::TrackRemoteDataSourceImpl) bind TrackRemoteDataSource::class
    singleOf(::TrackLocalDataSourceImpl) bind TrackLocalDataSource::class
}