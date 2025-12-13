package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.app.api.component.child.Screen
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Screen>>
    val toasts: Flow<ToastData>
}