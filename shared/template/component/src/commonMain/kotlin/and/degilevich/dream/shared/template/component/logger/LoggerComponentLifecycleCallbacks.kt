package and.degilevich.dream.shared.template.component.logger

import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.essenty.lifecycle.Lifecycle
import kotlin.reflect.KClass

internal class LoggerComponentLifecycleCallbacks<out State : Any, in Intent, out SideEffect>(
    private val componentKClass: KClass<out MVIComponent<State, Intent, SideEffect>>
) : Lifecycle.Callbacks {

    override fun onCreate() {
        logLifecycleEvent(::onCreate.name)
    }

    override fun onStart() {
        logLifecycleEvent(::onStart.name)
    }

    override fun onResume() {
        logLifecycleEvent(::onResume.name)
    }

    override fun onPause() {
        logLifecycleEvent(::onPause.name)
    }

    override fun onStop() {
        logLifecycleEvent(::onStop.name)
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