package and.degilevich.dream.shared.foundation.decompose.component.view

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks

interface ViewComponent<out State : Any, in Intent, out SideEffect> :
    MVIComponent<State, Intent, SideEffect>,
    ViewLifecycleCallbacks