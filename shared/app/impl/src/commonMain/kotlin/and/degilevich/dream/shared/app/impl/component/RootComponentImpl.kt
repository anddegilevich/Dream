package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.impl.component.child.Screen
import and.degilevich.dream.shared.app.impl.view.ComposeApp
import and.degilevich.dream.shared.core.toast.api.channel.ToastReceiveChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.album.component.details.impl.component.AlbumDetailsComponentImpl
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.SplashComponentImpl
import and.degilevich.dream.shared.feature.common.home.impl.component.HomeComponentImpl
import and.degilevich.dream.shared.feature.track.component.details.impl.component.TrackDetailsComponentImpl
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponent
import and.degilevich.dream.shared.navigation.impl.AppNavigationComponentImpl
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(componentContext), RootComponent, KoinComponent {

    private val navigationComponent = AppNavigationComponentImpl(
        componentContext = childContext(
            key = AppNavigationComponent::class.className()
        )
    )

    private val toastChannel: ToastReceiveChannel by inject()

    private val screens: Value<ChildStack<ScreenConfig, Screen>> = childStack(
        source = navigationComponent.screenNavigationSource,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.Splash,
        key = "screens",
        handleBackButton = true,
        childFactory = ::screenFactory,
    )

    private val toasts: Flow<ToastData> = toastChannel.receiveAsFlow()

    @Composable
    override fun Render() {
        ComposeApp(
            screens = screens,
            toasts = toasts
        )
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

            is ScreenConfig.Home -> Screen.Home(
                component = HomeComponentImpl(
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
        }
    }
}