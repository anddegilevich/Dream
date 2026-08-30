package and.degilevich.dream.shared.feature.common.component.drawer.impl.di

import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.DrawerComponentImpl
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.DrawerManagerImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun drawerComponentModule() = module {
    single<DrawerManager> { DrawerManagerImpl() }
    factory<DrawerComponent> { (componentContext: ComponentContext) ->
        DrawerComponentImpl(componentContext = componentContext)
    }
}
