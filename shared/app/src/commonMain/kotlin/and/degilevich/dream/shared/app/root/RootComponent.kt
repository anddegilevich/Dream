package and.degilevich.dream.shared.app.root

import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Child>>

    // FIXME: Add drawer child component
    // https://arkivanov.github.io/Decompose/component/child-components/

    // FIXME: Add components and ViewLifecycle callbacks
    sealed interface Child {
        class ArtistList : Child

        class ArtistDetails : Child
    }
}