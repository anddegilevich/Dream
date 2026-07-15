package and.degilevich.dream.shared.app.impl.view.screen

import and.degilevich.dream.shared.app.impl.component.child.Screen
import and.degilevich.dream.shared.app.impl.view.screen.animation.screensStackAnimation
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
internal fun ComposeScreens(
    screens: Value<ChildStack<ScreenConfig, Screen>>,
    modifier: Modifier = Modifier
) {
    Children(
        modifier = modifier,
        stack = screens,
        animation = screensStackAnimation()
    ) { child ->
        val screen = remember(child.configuration) { child.instance }
        screen.Render()
    }
}
