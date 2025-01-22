package and.degilevich.dream.shared.app.root

import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    override val childStack: Value<ChildStack<ScreenConfig, RootComponent.Child>>
        get() = TODO("Not yet implemented")
}