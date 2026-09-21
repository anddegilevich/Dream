package and.degilevich.dream.shared.feature.player.data.impl.di

import and.degilevich.dream.shared.feature.player.data.api.repository.PlayerRepository
import and.degilevich.dream.shared.feature.player.data.impl.remote.PlayerRemoteDataSource
import and.degilevich.dream.shared.feature.player.data.impl.remote.PlayerRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.player.data.impl.repository.PlayerRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerDataModule() = module {
    singleOf(::PlayerRemoteDataSourceImpl) bind PlayerRemoteDataSource::class
    singleOf(::PlayerRepositoryImpl) bind PlayerRepository::class
}
