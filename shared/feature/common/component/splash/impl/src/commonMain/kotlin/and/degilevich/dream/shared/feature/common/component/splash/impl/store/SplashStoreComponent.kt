package and.degilevich.dream.shared.feature.common.component.splash.impl.store

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class SplashStoreComponent(
    componentContext: ComponentContext
) : BaseStoreComponent<SplashState, SplashIntent, SplashSideEffect>(
    componentContext = componentContext,
    storeFactory = SplashStoreFactory(),
    stateConservator = SplashStateConservator()
)