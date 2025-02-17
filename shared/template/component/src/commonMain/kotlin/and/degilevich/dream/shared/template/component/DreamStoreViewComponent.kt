package and.degilevich.dream.shared.template.component

import and.degilevich.dream.shared.template.component.logger.LoggerExtendedLifecycleCallbacks
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.decompose.component.mvi.storeFactory.ComponentStoreFactory
import and.degilevich.dream.shared.foundation.decompose.component.view.StoreViewComponent
import and.degilevich.dream.shared.foundation.decompose.component.view.ViewComponent
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class DreamStoreViewComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any,
    out Message : Any
    >(
    componentKClass: KClass<out ViewComponent<UIState, Intent, SideEffect>>,
    componentContext: ComponentContext,
    storeFactory: ComponentStoreFactory<State, Intent, SideEffect>,
    initialUIState: UIState,
    uiStateMapper: Mapper<State, UIState>,
    stateConservator: ComponentStateConservator<State>,
) : StoreViewComponent<UIState, Intent, SideEffect, State, Message>(
    componentContext = componentContext,
    storeFactory = storeFactory,
    initialUIState = initialUIState,
    uiStateMapper = uiStateMapper,
    stateConservator = stateConservator
) {

    init {
        logLifecycleChanges(componentKClass)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out ViewComponent<UIState, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerExtendedLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}