package and.degilevich.dream.shared.foundation.decompose.component.render

import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface RenderMVIComponent<out State : Any, in Intent : Any, out SideEffect : Any> :
    MVIComponent<State, Intent, SideEffect>, RenderComponent