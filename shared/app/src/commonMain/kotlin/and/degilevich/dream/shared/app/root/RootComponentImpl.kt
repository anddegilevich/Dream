package and.degilevich.dream.shared.app.root

import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val screenNavigation: StackNavigation<ScreenConfig> = StackNavigation()

    override val screenStack: Value<ChildStack<ScreenConfig, RootComponent.Child>> = childStack(
        source = screenNavigation,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.ArtistList,
        handleBackButton = true,
        childFactory = ::screenFactory,
    )

    //FIXME: Add component
    @Suppress("UnusedParameter")
    private fun screenFactory(
        screenConfig: ScreenConfig,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (screenConfig) {
            is ScreenConfig.ArtistList -> {
                RootComponent.Child.ArtistList()
            }

            is ScreenConfig.ArtistDetails -> {
                RootComponent.Child.ArtistDetails()
            }
        }
    }
}