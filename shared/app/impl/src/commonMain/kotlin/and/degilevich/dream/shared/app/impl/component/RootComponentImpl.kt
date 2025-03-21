package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.impl.logger.StoreFactoryLogger
import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import and.degilevich.dream.shared.feature.artist.component.list.impl.component.ArtistListComponentImpl
import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.user.component.profile.impl.component.ProfileComponentImpl
import and.degilevich.dream.shared.foundation.dispatcher.DefaultKMPDispatchers
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.DreamNavigationComponent
import and.degilevich.dream.shared.navigation.impl.DreamNavigationComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
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

    private val coroutineScope = coroutineScope(DefaultKMPDispatchers.main)

    private val storeFactory = LoggingStoreFactory(
        delegate = DefaultStoreFactory(),
        logger = StoreFactoryLogger()
    )

    private val navigationComponent: DreamNavigationComponent = DreamNavigationComponentImpl(
        componentContext = childContext(
            key = DreamNavigationComponent::class.className()
        )
    )

    private val toastChannel: ToastChannel by inject()
    private val filePickerRequestChannel: FilePickerRequestChannel by inject()
    private val filePickerResultChannel: FilePickerResultChannel by inject()

    override val screenStack: Value<ChildStack<ScreenConfig, RootComponent.Child>> = childStack(
        source = navigationComponent.screenNavigationSource,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.ArtistList,
        handleBackButton = true,
        childFactory = ::screenFactory,
    )

    override val toasts: Flow<ToastData> = toastChannel.value
    override val filePickerRequests: Flow<FilePickerRequest> = filePickerRequestChannel.value

    override fun handleFilePickerResult(result: FilePickerResult) {
        coroutineScope.launch {
            filePickerResultChannel.send(result)
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
                        navArgs = screenConfig.navArgs
                    )
                )
            }

            ScreenConfig.Profile -> {
                RootComponent.Child.Profile(
                    component = ProfileComponentImpl(
                        componentContext = componentContext,
                        storeFactory = storeFactory
                    )
                )
            }
        }
    }
}