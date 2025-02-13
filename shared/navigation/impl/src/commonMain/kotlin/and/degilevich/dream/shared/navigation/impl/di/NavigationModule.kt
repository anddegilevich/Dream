package and.degilevich.dream.shared.navigation.impl.di

import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import and.degilevich.dream.shared.navigation.api.dream.channel.ScreenNavigationActionChannel
import and.degilevich.dream.shared.navigation.impl.channel.ScreenNavigationActionChannelImpl
import and.degilevich.dream.shared.navigation.impl.navigator.DreamNavigatorImpl
import and.degilevich.dream.shared.navigation.impl.navigator.ScreenNavigator
import and.degilevich.dream.shared.navigation.impl.result.DreamNavigationResultManager
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun navigationModule() = module {
    singleOf(::ScreenNavigationActionChannelImpl) bind ScreenNavigationActionChannel::class
    singleOf(::DreamNavigationResultManager)
    singleOf(::ScreenNavigator)
    singleOf(::DreamNavigatorImpl) bind DreamNavigator::class
}