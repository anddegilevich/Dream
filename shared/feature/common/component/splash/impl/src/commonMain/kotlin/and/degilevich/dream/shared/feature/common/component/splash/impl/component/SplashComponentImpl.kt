package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashUIState
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.SplashStoreComponent
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.template.component.impl.UIStoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

class SplashComponentImpl(
    componentContext: ComponentContext
) : UIStoreComponentTemplate<SplashUIState, SplashIntent, SplashSideEffect, SplashState>(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        SplashStoreComponent(componentContext = childComponentContext)
    },
    uiStateMapper = SplashUIStateMapper(),
    initialUIState = SplashUIState.empty()
),
    SplashComponent