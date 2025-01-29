package and.degilevich.dream.shared.common.component.mvi.executor

import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import org.koin.core.component.KoinComponent

abstract class AbstractExecutor<State : Any, Intent : Any, SideEffect : Any, Message : Any> :
    CoroutineExecutor<Intent, Nothing, State, Message, SideEffect>(
        mainContext = DefaultKMPDispatchers.main
    ),
    KoinComponent