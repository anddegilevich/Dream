package and.degilevich.dream.shared.feature.common.component.drawer.impl.di

import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponentFactory
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.DrawerComponentFactoryImpl
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.DrawerManagerImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun drawerComponentModule() = module {
    single<DrawerManager> { DrawerManagerImpl() }
    factoryOf(::DrawerComponentFactoryImpl) bind DrawerComponentFactory::class
}
