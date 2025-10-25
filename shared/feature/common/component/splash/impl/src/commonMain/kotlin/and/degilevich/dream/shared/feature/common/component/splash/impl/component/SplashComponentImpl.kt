package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashSideEffect
import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashUIState
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashState
import and.degilevich.dream.shared.template.component.impl.BaseBinderComponent
import com.arkivanov.decompose.ComponentContext

class SplashComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<SplashUIState, SplashIntent, SplashSideEffect, SplashState>(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        SplashDomainComponent(componentContext = childComponentContext)
    },
    uiStateMapper = SplashUIStateMapper(),
    initialUIState = SplashUIState.empty()
),
    SplashComponent