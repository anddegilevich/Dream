package and.degilevich.dream.shared.feature.player.ui.impl.di

import and.degilevich.dream.shared.feature.player.ui.api.mapper.PlaybackStateDataToPlaybackProgressUIDataMapper
import and.degilevich.dream.shared.feature.player.ui.impl.mapper.PlaybackStateDataToPlaybackProgressUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerUIModule() = module {
    factoryOf(::PlaybackStateDataToPlaybackProgressUIDataMapperImpl)
        .bind(PlaybackStateDataToPlaybackProgressUIDataMapper::class)
}
