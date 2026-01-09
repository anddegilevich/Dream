package and.degilevich.dream.shared.resource.impl.di

import and.degilevich.dream.shared.resource.api.pallet.PalletManager
import and.degilevich.dream.shared.resource.impl.pallet.PalletManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun resourceModule() = module {
    includes(resourcePlatformModule())
    singleOf(::PalletManagerImpl) bind PalletManager::class
}