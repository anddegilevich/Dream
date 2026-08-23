package and.degilevich.dream.shared.core.deeplink.impl.di

import and.degilevich.dream.shared.core.deeplink.api.manager.DeeplinkManager
import and.degilevich.dream.shared.core.deeplink.impl.manager.DeeplinkManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun deeplinkModule() = module {
    singleOf(::DeeplinkManagerImpl) bind DeeplinkManager::class
}
