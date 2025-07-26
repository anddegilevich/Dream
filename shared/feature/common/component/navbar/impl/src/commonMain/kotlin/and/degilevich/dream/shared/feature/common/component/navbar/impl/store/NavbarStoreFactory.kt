package and.degilevich.dream.shared.feature.common.component.navbar.impl.store

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.store.model.NavbarState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class NavbarStoreFactory : BaseComponentStoreFactory<
    NavbarState,
    NavbarIntent,
    NavbarSideEffect
    >(
    storeName = NavbarStore::class.className(),
    executorFactory = { lifecycle -> NavbarExecutor(lifecycle = lifecycle) }
)