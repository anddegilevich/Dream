package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.component.children.Navbar
import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestReceiveChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultSendChannel
import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.core.toast.api.channel.ToastReceiveChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.album.component.details.impl.component.AlbumDetailsComponentImpl
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentImpl
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarComponentImpl
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.SplashComponentImpl
import and.degilevich.dream.shared.feature.search.component.search.impl.component.SearchComponentImpl
import and.degilevich.dream.shared.feature.track.component.details.impl.component.TrackDetailsComponentImpl
import and.degilevich.dream.shared.feature.user.component.profile.impl.component.ProfileComponentImpl
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.ActiveScreenConfigValueHolder
import and.degilevich.dream.shared.navigation.api.model.config.NavbarConfig
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponent
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponentImpl
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.subscribe
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, KoinComponent, ComponentContext by componentContext {

    private val coroutineScope = coroutineScope()

    private val navigationComponent = AppNavigationComponentImpl(
        componentContext = childContext(
            key = AppNavigationComponent::class.className()
        )
    )

    private val toastChannel: ToastReceiveChannel by inject()
    private val filePickerRequestChannel: FilePickerRequestReceiveChannel by inject()
    private val filePickerResultChannel: FilePickerResultSendChannel by inject()
    private val activeScreenConfigValueHolder: ActiveScreenConfigValueHolder by inject()

    override val screenStack: Value<ChildStack<ScreenConfig, Screen>> = childStack(
        source = navigationComponent.screenNavigationSource,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.Splash,
        key = "screens",
        handleBackButton = true,
        childFactory = ::screenFactory,
    )
    override val navbar: Value<ChildSlot<NavbarConfig, Navbar>> = childSlot(
        source = navigationComponent.navbarNavigationSource,
        serializer = NavbarConfig.serializer(),
        key = "navbar",
        childFactory = { _, componentContext ->
            navbarFactory(componentContext = componentContext)
        }
    )

    override val toasts: Flow<ToastData> = toastChannel.receiveAsFlow()
    override val filePickerRequests: Flow<FilePickerRequest> = filePickerRequestChannel.receiveAsFlow()

    init {
        subscribeToScreenStack()
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

            is ScreenConfig.AlbumDetails -> {
                Screen.AlbumDetails(
                    component = AlbumDetailsComponentImpl(
                        componentContext = componentContext,
                        navArgs = screenConfig.navArgs
                    )
                )
            }

            is ScreenConfig.TrackDetails -> {
                Screen.TrackDetails(
                    component = TrackDetailsComponentImpl(
                        componentContext = componentContext,
                        navArgs = screenConfig.navArgs
                    )
                )
            }

            is ScreenConfig.Search -> {
                Screen.Search(
                    component = SearchComponentImpl(
                        componentContext = componentContext
                    )
                )
            }
        }
    }

    private fun navbarFactory(
        componentContext: ComponentContext
    ): Navbar {
        return Navbar(
            component = NavbarComponentImpl(
                componentContext = componentContext
            )
        )
    }

    override fun handleFilePickerResult(result: FilePickerResult) {
        coroutineScope.launch {
            filePickerResultChannel.send(result)
        }
    }

    private fun subscribeToScreenStack() {
        screenStack.subscribe(lifecycle = lifecycle) { stack ->
            val activeConfig = stack.active.configuration
            coroutineScope.launch {
                activeScreenConfigValueHolder.reduce { activeConfig }
            }
            val shouldDisplayNavbar = activeConfig in setOf(ScreenConfig.Dashboard, ScreenConfig.Search)
            if (shouldDisplayNavbar) {
                navigationComponent.navbarNavigator.activate(NavbarConfig)
            } else {
                navigationComponent.navbarNavigator.dismiss()
            }
        }
    }
}