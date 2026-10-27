package and.degilevich.dream.shared.feature.player.data.mapper.impl.di

import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlaybackStateResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.PlayHistoryOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.PlaybackStateOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.PlaybackStateResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.player.data.mapper.impl.remote.RecentlyPlayedResponseToResultMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerDataMapperModule() = module {
    factoryOf(::PlayHistoryOutputToDataMapperImpl) bind PlayHistoryOutputToDataMapper::class
    factoryOf(::RecentlyPlayedResponseToResultMapperImpl) bind RecentlyPlayedResponseToResultMapper::class
    factoryOf(::PlaybackStateOutputToDataMapperImpl) bind PlaybackStateOutputToDataMapper::class
    factoryOf(::PlaybackStateResponseToResultMapperImpl) bind PlaybackStateResponseToResultMapper::class
}
