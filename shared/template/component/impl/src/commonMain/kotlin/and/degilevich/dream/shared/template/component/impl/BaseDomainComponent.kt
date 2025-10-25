package and.degilevich.dream.shared.template.component.impl

import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.foundation.decompose.component.mvi.AbstractMVIComponent
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.navigation.api.AppNavigator
import and.degilevich.dream.shared.template.component.impl.logger.LoggerComponentLifecycleCallbacks
import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseDomainComponent<State : Any, in Intent : Any, SideEffect : Any>(
    componentContext: ComponentContext,
    stateConservator: ComponentStateConservator<State>
) : AbstractMVIComponent<State, Intent, SideEffect>(
    componentContext = componentContext,
    stateConservator = stateConservator
),
    KoinComponent {

    protected val appNavigator: AppNavigator by inject()
    protected val toastController: ToastController by inject()

    init {
        logLifecycleChanges(this::class.simpleName.orEmpty())
    }

    private fun logLifecycleChanges(componentKey: String) {
        lifecycle.subscribe(
            callbacks = LoggerComponentLifecycleCallbacks(componentKey = componentKey)
        )
    }
}