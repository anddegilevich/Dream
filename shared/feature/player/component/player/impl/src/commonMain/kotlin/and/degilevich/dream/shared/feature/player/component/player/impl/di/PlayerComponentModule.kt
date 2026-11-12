package and.degilevich.dream.shared.feature.player.component.player.impl.di

import and.degilevich.dream.shared.feature.player.component.player.api.component.PlayerComponentFactory
import and.degilevich.dream.shared.feature.player.component.player.impl.component.PlayerComponentFactoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playerComponentModule() = module {
    factoryOf(::PlayerComponentFactoryImpl) bind PlayerComponentFactory::class
}
