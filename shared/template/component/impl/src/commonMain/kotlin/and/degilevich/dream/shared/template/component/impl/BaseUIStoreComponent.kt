package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.store.UIStoreComponent
import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class BaseUIStoreComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any,
    >(
    componentContext: ComponentContext,
    storeComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    uiStateMapper: Mapper<State, UIState>,
    initialUIState: UIState
) : UIStoreComponent<UIState, Intent, SideEffect, State>(
    componentContext = componentContext,
    storeComponentFactory = storeComponentFactory,
    uiStateMapper = uiStateMapper,
    initialUIState = initialUIState
) {

    init {
        logLifecycleChanges(this::class)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out MVIComponent<UIState, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}