package and.degilevich.dream.shared.feature.common.component.splash.impl.store

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class SplashStoreFactory : BaseComponentStoreFactory<SplashState, SplashIntent, SplashSideEffect>(
    storeName = SplashStore::class.className(),
    executorFactory = { lifecycle ->
        SplashExecutor(lifecycle = lifecycle)
    }
)