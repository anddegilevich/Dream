package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.feature.artist.component.details.impl.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.artist.component.list.impl.component.ArtistListComponentImpl
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
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val coroutineScope = coroutineScope(
        context = DefaultKMPDispatchers.main
    )

    private val storeFactory: StoreFactory = DefaultStoreFactory()

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

    private fun screenFactory(
        screenConfig: ScreenConfig,
        componentContext: ComponentContext
    ): RootComponent.Child {
        return when (screenConfig) {
            is ScreenConfig.ArtistList -> {
                RootComponent.Child.ArtistList(
                    component = ArtistListComponentImpl(
                        componentContext = componentContext,
                        storeFactory = storeFactory
                    )
                )
            }

            is ScreenConfig.ArtistDetails -> {
                RootComponent.Child.ArtistDetails(
                    component = ArtistDetailsComponentImpl(
                        componentContext = componentContext,
                        config = screenConfig
                    )
                )
            }
        }
    }
}