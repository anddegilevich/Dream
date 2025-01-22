package and.degilevich.dream.shared.navigation.impl.di

import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import and.degilevich.dream.shared.navigation.impl.manager.NavigationActionManager
import and.degilevich.dream.shared.navigation.impl.manager.NavigationActionManagerImpl
import and.degilevich.dream.shared.navigation.impl.navigator.DreamNavigatorImpl
import and.degilevich.dream.shared.navigation.impl.navigator.DreamScreenNavigator
import and.degilevich.dream.shared.navigation.impl.result.DreamNavigationResultManager
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun navigationModule() = module {
    singleOf(::NavigationActionManagerImpl) bind NavigationActionManager::class
    singleOf(::DreamNavigationResultManager)
    singleOf(::DreamScreenNavigator)
    singleOf(::DreamNavigatorImpl) bind DreamNavigator::class
}