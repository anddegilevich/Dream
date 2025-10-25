package and.degilevich.dream.shared.template.component.impl.logger

import and.degilevich.dream.shared.logger.Log
import com.arkivanov.essenty.lifecycle.Lifecycle

internal class LoggerComponentLifecycleCallbacks(
    private val componentKey: String
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
            message = "$componentKey: $event"
        )
    }
}