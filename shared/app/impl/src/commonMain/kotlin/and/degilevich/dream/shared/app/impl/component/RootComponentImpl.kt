package and.degilevich.dream.shared.app.impl.component

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.impl.component.child.Screen
import and.degilevich.dream.shared.app.impl.view.ComposeApp
import and.degilevich.dream.shared.core.toast.api.channel.ToastReceiveChannel
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponentFactory
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponentFactory
import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponentFactory
import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponentFactory
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponentFactory
import and.degilevich.dream.shared.feature.playlist.component.details.api.component.PlaylistDetailsComponentFactory
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponentFactory
import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponentFactory
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.logger.Log
import and.degilevich.dream.shared.navigation.api.component.AppNavigationComponent
import and.degilevich.dream.shared.navigation.api.component.AppNavigationComponentFactory
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject

class RootComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(componentContext), RootComponent, KoinComponent {

    private val navigationComponent: AppNavigationComponent = get<AppNavigationComponentFactory>().create(
        componentContext = childContext(
            key = AppNavigationComponent::class.className()
        )
    )

    private val toastChannel: ToastReceiveChannel by inject()
    private val splashComponentFactory: SplashComponentFactory by inject()
    private val homeComponentFactory: HomeComponentFactory by inject()
    private val loginComponentFactory: LoginComponentFactory by inject()
    private val artistDetailsComponentFactory: ArtistDetailsComponentFactory by inject()
    private val albumDetailsComponentFactory: AlbumDetailsComponentFactory by inject()
    private val playlistDetailsComponentFactory: PlaylistDetailsComponentFactory by inject()
    private val trackDetailsComponentFactory: TrackDetailsComponentFactory by inject()
    private val likedTracksComponentFactory: LikedTracksComponentFactory by inject()

    private val screens: Value<ChildStack<ScreenConfig, Screen>> = childStack(
        source = navigationComponent.screenNavigationSource,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.Splash,
        key = SCREENS_KEY,
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
                component = splashComponentFactory.create(
                    componentContext = componentContext
                )
            )

            is ScreenConfig.Home -> Screen.Home(
                component = homeComponentFactory.create(
                    componentContext = componentContext
                )
            )

            is ScreenConfig.Login -> Screen.Login(
                component = loginComponentFactory.create(
                    componentContext = componentContext
                )
            )

            is ScreenConfig.ArtistDetails -> Screen.ArtistDetails(
                component = artistDetailsComponentFactory.create(
                    componentContext = componentContext,
                    navArgs = screenConfig.navArgs
                )
            )

            is ScreenConfig.AlbumDetails -> Screen.AlbumDetails(
                component = albumDetailsComponentFactory.create(
                    componentContext = componentContext,
                    navArgs = screenConfig.navArgs
                )
            )

            is ScreenConfig.PlaylistDetails -> Screen.PlaylistDetails(
                component = playlistDetailsComponentFactory.create(
                    componentContext = componentContext,
                    navArgs = screenConfig.navArgs
                )
            )

            is ScreenConfig.TrackDetails -> Screen.TrackDetails(
                component = trackDetailsComponentFactory.create(
                    componentContext = componentContext,
                    navArgs = screenConfig.navArgs
                )
            )

            is ScreenConfig.LikedTracks -> Screen.LikedTracks(
                component = likedTracksComponentFactory.create(
                    componentContext = componentContext
                )
            )
        }
    }

    private companion object {
        const val SCREENS_KEY = "screens"
    }
}