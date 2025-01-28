package and.degilevich.dream.shared.app.root

import and.degilevich.dream.shared.foundation.decompose.navigator.ext.executeNavigationAction
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.manager.NavigationActionManager
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val coroutineScope = coroutineScope(
        context = DefaultKMPDispatchers.main
    )

    private val navigationActionManager: NavigationActionManager by inject()

    private val screenNavigation: StackNavigation<ScreenConfig> = StackNavigation()

    override val screenStack: Value<ChildStack<ScreenConfig, RootComponent.Child>> = childStack(
        source = screenNavigation,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.ArtistList,
        handleBackButton = true,
        childFactory = ::screenFactory,
    )

    init {
        subscribeNavigationActions()
    }

    private fun subscribeNavigationActions() {
        coroutineScope.launch {
            navigationActionManager.screenAction.collect { action ->
                screenNavigation.executeNavigationAction(action)
            }
        }
    }

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