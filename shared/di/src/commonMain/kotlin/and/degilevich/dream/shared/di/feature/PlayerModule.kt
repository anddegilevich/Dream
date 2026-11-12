package and.degilevich.dream.shared.di.feature

import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.di.miniPlayerComponentModule
import and.degilevich.dream.shared.feature.player.component.player.impl.di.playerComponentModule
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.di.recentlyPlayedComponentModule
import and.degilevich.dream.shared.feature.player.data.impl.di.playerDataModule
import and.degilevich.dream.shared.feature.player.data.mapper.impl.di.playerDataMapperModule
import and.degilevich.dream.shared.feature.player.domain.impl.di.playerDomainModule
import and.degilevich.dream.shared.feature.player.ui.impl.di.playerUIModule
import org.koin.dsl.module

internal fun playerModule() = module {
    includes(playerDataMapperModule())
    includes(playerDataModule())
    includes(playerDomainModule())
    includes(playerUIModule())
    includes(recentlyPlayedComponentModule())
    includes(miniPlayerComponentModule())
    includes(playerComponentModule())
}
