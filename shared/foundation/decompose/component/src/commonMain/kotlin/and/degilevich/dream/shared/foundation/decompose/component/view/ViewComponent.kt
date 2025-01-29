package and.degilevich.dream.shared.foundation.decompose.component.view

import and.degilevich.dream.shared.foundation.decompose.component.MVIComponent
import and.degilevich.dream.shared.foundation.decompose.lifecycle.view.ViewLifecycleCallbacks

interface ViewComponent<State : Any, Intent, SideEffect> :
    MVIComponent<State, Intent, SideEffect>,
    ViewLifecycleCallbacks