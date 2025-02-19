package and.degilevich.dream.shared.foundation.decompose.component.store.executor

import and.degilevich.dream.shared.foundation.decompose.lifecycle.ExtendedLifecycle
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor

abstract class AbstractExecutor<State : Any, in Intent : Any, SideEffect : Any, Message : Any>(
    lifecycle: ExtendedLifecycle
) :
    CoroutineExecutor<Intent, Nothing, State, Message, SideEffect>(
        mainContext = DefaultKMPDispatchers.main
    ),
    LifecycleOwner by object : LifecycleOwner {
        override val lifecycle: Lifecycle = lifecycle
    }