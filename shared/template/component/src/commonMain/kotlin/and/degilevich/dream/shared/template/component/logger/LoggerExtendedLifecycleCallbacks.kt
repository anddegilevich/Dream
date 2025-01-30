package and.degilevich.dream.shared.template.component.logger

import and.degilevich.dream.shared.core.logger.Log
import and.degilevich.dream.shared.foundation.decompose.component.view.ViewComponent
import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlin.reflect.KClass

internal class LoggerExtendedLifecycleCallbacks<out State : Any, in Intent, out SideEffect>(
    private val componentKClass: KClass<out ViewComponent<State, Intent, SideEffect>>
) : ExtendedLifecycle.Callbacks {

    override fun onCreate() {
        logLifecycleEvent(::onCreate.name)
    }

    override fun onStart() {
        logLifecycleEvent(::onStart.name)
    }

    override fun onResume() {
        logLifecycleEvent(::onResume.name)
    }

    override fun onViewCreated() {
        logLifecycleEvent(::onViewCreated.name)
    }

    override fun onPause() {
        logLifecycleEvent(::onPause.name)
    }

    override fun onStop() {
        logLifecycleEvent(::onStop.name)
    }

    override fun onViewDestroyed() {
        logLifecycleEvent(::onViewDestroyed.name)
    }

    override fun onDestroy() {
        logLifecycleEvent(::onDestroy.name)
    }

    private fun logLifecycleEvent(event: String) {
        Log.info(
            message = "${componentKClass.className()} $event"
        )
    }
}