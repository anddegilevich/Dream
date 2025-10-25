package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.decompose.component.mvi.BinderComponent
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext

abstract class BaseBinderComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any,
    >(
    componentContext: ComponentContext,
    domainComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    uiStateMapper: Mapper<State, UIState>,
    initialUIState: UIState
) : BinderComponent<UIState, Intent, SideEffect, State>(
    componentContext = componentContext,
    domainComponentFactory = domainComponentFactory,
    uiStateMapper = uiStateMapper,
    initialUIState = initialUIState
) {

    init {
        logLifecycleChanges(this::class.simpleName.orEmpty())
    }

    private fun logLifecycleChanges(componentKey: String) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKey = componentKey)
        )
    }
}