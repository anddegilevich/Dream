package and.degilevich.dream.shared.app.api.design.screen

import and.degilevich.dream.shared.app.api.component.child.Screen
import and.degilevich.dream.shared.app.api.design.screen.animation.screensStackAnimation
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
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
        modifier = modifier,
        stack = screens,
        animation = screensStackAnimation()
    ) { child ->
        val screen = remember(child.configuration) { child.instance }
        screen.Render()
    }
}