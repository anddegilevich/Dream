package and.degilevich.dream.shared.feature.track.source.impl.di

import and.degilevich.dream.shared.feature.track.source.api.remote.TrackRemoteDataSource
import and.degilevich.dream.shared.feature.track.source.impl.remote.TrackRemoteDataSourceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackSourceModule() = module {
    singleOf(::TrackRemoteDataSourceImpl) bind TrackRemoteDataSource::class
}