package and.degilevich.dream.shared.template.component

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.store.UIStoreComponent
import and.degilevich.dream.shared.foundation.decompose.component.view.ViewComponent
import and.degilevich.dream.shared.template.component.logger.LoggerExtendedLifecycleCallbacks
import and.degilevich.dream.shared.foundation.model.mapper.Mapper
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class DreamUIStoreComponent<
    out UIState : Any,
    in Intent : Any,
    out SideEffect : Any,
    State : Any,
    >(
    componentContext: ComponentContext,
    storeComponentFactory: (childComponentContext: ComponentContext) -> MVIComponent<State, Intent, SideEffect>,
    initialUIState: UIState,
    uiStateMapper: Mapper<State, UIState>
) : UIStoreComponent<UIState, Intent, SideEffect, State>(
    componentContext = componentContext,
    initialUIState = initialUIState,
    uiStateMapper = uiStateMapper,
    storeComponentFactory = storeComponentFactory
) {

    init {
        logLifecycleChanges(this::class)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out ViewComponent<UIState, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerExtendedLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}