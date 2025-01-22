package and.degilevich.dream.shared.app.root

import and.degilevich.dream.shared.common.component.Component
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {

    val childStack: Value<ChildStack<ScreenConfig, Child>>

    sealed interface Child {
        val component: Component<*, *, *>

        class Home(
            override val component: Component<*, *, *>
        ) : Child

        class Artist(
            override val component: Component<*, *, *>
        ) : Child
    }
}