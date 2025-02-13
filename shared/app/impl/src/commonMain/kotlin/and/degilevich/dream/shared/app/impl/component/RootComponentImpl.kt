package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.impl.logger.StoreFactoryLogger
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.artist.component.list.impl.component.ArtistListComponentImpl
import and.degilevich.dream.shared.foundation.decompose.navigator.ext.executeNavigationAction
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import and.degilevich.dream.shared.core.logger.Log
import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.channel.ScreenNavigationActionChannel
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.arkivanov.mvikotlin.logging.store.LoggingStoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val coroutineScope = coroutineScope(
        context = DefaultKMPDispatchers.main
    )

    private val storeFactory = LoggingStoreFactory(
        delegate = DefaultStoreFactory(),
        logger = StoreFactoryLogger()
    )

    private val screenNavigationActionChannel: ScreenNavigationActionChannel by inject()
    private val toastChannel: ToastChannel by inject()

    private val screenNavigation: StackNavigation<ScreenConfig> = StackNavigation()

    override val screenStack: Value<ChildStack<ScreenConfig, RootComponent.Child>> = childStack(
        source = screenNavigation,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.ArtistList,
        handleBackButton = true,
        childFactory = ::screenFactory,
    )

    override val toasts: Flow<ToastData> = toastChannel.value

    init {
        subscribeToNavigationActions()
    }

    private fun subscribeToNavigationActions() {
        coroutineScope.launch {
            screenNavigationActionChannel.value.collect { action ->
                screenNavigation.executeNavigationAction(action)
            }
        }
    }

    private fun screenFactory(
        screenConfig: ScreenConfig,
        componentContext: ComponentContext
    ): RootComponent.Child {
        Log.info("Navigate to -> $screenConfig")
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
                        storeFactory = storeFactory,
                        config = screenConfig
                    )
                )
            }
        }
    }
}