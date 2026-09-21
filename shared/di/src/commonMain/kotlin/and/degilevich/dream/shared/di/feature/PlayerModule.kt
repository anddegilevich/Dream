package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.di.recentlyPlayedComponentModule
import and.degilevich.dream.shared.feature.player.data.impl.di.playerDataModule
import and.degilevich.dream.shared.feature.player.data.mapper.impl.di.playerDataMapperModule
import and.degilevich.dream.shared.feature.player.domain.impl.di.playerDomainModule
import org.koin.dsl.module

internal fun playerModule() = module {
    includes(playerDataMapperModule())
    includes(playerDataModule())
    includes(playerDomainModule())
    includes(recentlyPlayedComponentModule())
}
