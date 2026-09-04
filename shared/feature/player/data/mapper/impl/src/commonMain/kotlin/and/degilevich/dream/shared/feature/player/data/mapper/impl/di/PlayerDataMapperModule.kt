package and.degilevich.dream.shared.feature.player.data.mapper.impl.di

import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.PlayHistoryOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.RecentlyPlayedResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerDataMapperModule() = module {
    factoryOf(::PlayHistoryOutputToDataMapperImpl) bind PlayHistoryOutputToDataMapper::class
    factoryOf(::RecentlyPlayedResponseToResultMapperImpl) bind RecentlyPlayedResponseToResultMapper::class
}
