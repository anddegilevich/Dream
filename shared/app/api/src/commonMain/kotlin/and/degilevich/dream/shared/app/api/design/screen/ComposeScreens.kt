package and.degilevich.dream.shared.app.api.design.screen

import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.app.api.design.screen.animation.screensStackAnimation
import and.degilevich.dream.shared.feature.album.component.details.api.design.AlbumDetailsScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.collectState
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.feature.common.component.splash.api.design.SplashScreen
import and.degilevich.dream.shared.feature.track.component.details.api.design.TrackDetailsScreen
import and.degilevich.dream.shared.feature.user.component.profile.api.design.ProfileScreen
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
fun ComposeScreens(
    screens: Value<ChildStack<ScreenConfig, Screen>>,
    modifier: Modifier = Modifier
) {
    Children(
        modifier = modifier.fillMaxSize(),
        stack = screens,
        animation = screensStackAnimation()
    ) { screen ->
        val screenComponent = remember(screen.configuration) { screen.instance }

        when (screenComponent) {
            is Screen.Splash -> {
                SplashScreen()
            }

            is Screen.Dashboard -> {
                DashboardScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is Screen.ArtistDetails -> {
                ArtistDetailsScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is Screen.Profile -> {
                ProfileScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is Screen.AlbumDetails -> {
                AlbumDetailsScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is Screen.TrackDetails -> {
                TrackDetailsScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }
            is Screen.Search -> {
                // FIXME: Implement later
            }
        }
    }
}