package and.degilevich.dream.shared.app

import and.degilevich.dream.shared.app.root.RootComponent
import and.degilevich.dream.shared.foundation.decompose.compose.animation.defaultStackAnimation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.value.getValue

@Composable
fun DreamApp(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val screenStack by rootComponent.screenStack

    MaterialTheme {
        Children(
            modifier = modifier,
            stack = screenStack,
            animation = defaultStackAnimation()
        ) { screen ->
            val screenComponent = remember(screen) { screen.instance }
            when (screenComponent) {
                is RootComponent.Child.ArtistList -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Artist list"
                        )
                    }
                }

                is RootComponent.Child.ArtistDetails -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Artist details"
                        )
                    }
                }
            }
        }
    }
}