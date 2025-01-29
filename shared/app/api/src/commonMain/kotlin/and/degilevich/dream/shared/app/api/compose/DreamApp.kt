package and.degilevich.dream.shared.app.api.compose

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.compose.ext.collectState
import and.degilevich.dream.shared.feature.artist.component.details.api.compose.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.list.api.compose.ArtistListScreen
import and.degilevich.dream.shared.foundation.decompose.compose.animation.defaultStackAnimation
import and.degilevich.dream.shared.foundation.decompose.compose.lifecycle.SubscribeToLifecycleDisposalEffect
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
fun DreamApp(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    MaterialTheme {
        Children(
            modifier = modifier.fillMaxSize(),
            stack = rootComponent.screenStack,
            animation = defaultStackAnimation()
        ) { screen ->
            val screenComponent = remember(screen.configuration) { screen.instance }

            when (screenComponent) {
                is RootComponent.Child.ArtistList -> {
                    ArtistListScreen(
                        state = screenComponent.collectState(),
                        onIntent = screenComponent::handleIntent
                    )
                }

                is RootComponent.Child.ArtistDetails -> {
                    ArtistDetailsScreen(
                        state = screenComponent.collectState(),
                        onIntent = screenComponent::handleIntent
                    )
                }
            }

            SubscribeToLifecycleDisposalEffect(screenComponent)
        }
    }
}