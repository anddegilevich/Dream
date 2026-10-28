package and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.di

import and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component.MiniPlayerComponentFactory
import and.degilevich.dream.shared.feature.player.component.miniPlayer.impl.component.MiniPlayerComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun miniPlayerComponentModule() = module {
    factoryOf(::MiniPlayerComponentFactoryImpl) bind MiniPlayerComponentFactory::class
}
