package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import and.degilevich.dream.shared.feature.artist.component.list.impl.component.ArtistListComponentImpl
import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentImpl
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.SplashComponentImpl
import and.degilevich.dream.shared.feature.user.component.profile.impl.component.ProfileComponentImpl
import and.degilevich.dream.shared.foundation.coroutine.dispatcher.DefaultKMPDispatchers
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponent
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val coroutineScope = coroutineScope(DefaultKMPDispatchers.main)

    private val navigationComponent: AppNavigationComponent = AppNavigationComponentImpl(
        componentContext = childContext(
            key = AppNavigationComponent::class.className()
        )
    )

    private val toastChannel: ToastChannel by inject()
    private val filePickerRequestChannel: FilePickerRequestChannel by inject()
    private val filePickerResultChannel: FilePickerResultChannel by inject()

    override val screenStack: Value<ChildStack<ScreenConfig, Screen>> = childStack(
        source = navigationComponent.screenNavigationSource,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.Splash,
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
    ): Screen {
        Log.info("Navigate to -> $screenConfig")
        return when (screenConfig) {
            is ScreenConfig.Splash -> Screen.Splash(
                component = SplashComponentImpl(
                    componentContext = componentContext
                )
            )

            is ScreenConfig.Dashboard -> Screen.Dashboard(
                component = DashboardComponentImpl(
                    componentContext = componentContext
                )
            )

            is ScreenConfig.ArtistList -> {
                Screen.ArtistList(
                    component = ArtistListComponentImpl(
                        componentContext = componentContext
                    )
                )
            }

            is ScreenConfig.ArtistDetails -> {
                Screen.ArtistDetails(
                    component = ArtistDetailsComponentImpl(
                        componentContext = componentContext,
                        navArgs = screenConfig.navArgs
                    )
                )
            }

            is ScreenConfig.Profile -> {
                Screen.Profile(
                    component = ProfileComponentImpl(
                        componentContext = componentContext
                    )
                )
            }
        }
    }
}