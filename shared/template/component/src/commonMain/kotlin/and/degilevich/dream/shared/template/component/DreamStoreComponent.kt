package and.degilevich.dream.shared.template.component

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactory
import and.degilevich.dream.shared.foundation.decompose.component.store.StoreComponent
import and.degilevich.dream.shared.template.component.logger.LoggerExtendedLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import kotlin.reflect.KClass

abstract class DreamStoreComponent<out State : Any, in Intent : Any, out SideEffect : Any>(
    componentContext: ComponentContext,
    storeFactory: ComponentStoreFactory<State, Intent, SideEffect>,
    stateConservator: ComponentStateConservator<State>,
) : StoreComponent<State, Intent, SideEffect>(
    componentContext = componentContext,
    storeFactory = storeFactory,
    stateConservator = stateConservator
) {

    init {
        logLifecycleChanges(this::class)
    }

    private fun logLifecycleChanges(componentKClass: KClass<out MVIComponent<State, Intent, SideEffect>>) {
        lifecycle.subscribe(
            callbacks = LoggerExtendedLifecycleCallbacks(componentKClass = componentKClass)
        )
    }
}