package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.di

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component.RecentlyPlayedComponentFactory
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component.RecentlyPlayedComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun recentlyPlayedComponentModule() = module {
    factoryOf(::RecentlyPlayedComponentFactoryImpl) bind RecentlyPlayedComponentFactory::class
}
