package and.degilevich.dream.shared.app.api.design.screen.animation

import and.degilevich.dream.shared.app.api.component.child.Screen
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.arkivanov.decompose.FaultyDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

@OptIn(FaultyDecomposeApi::class)
@Composable
internal fun screensStackAnimation(): StackAnimation<ScreenConfig, Screen> {
    val processor = remember { ScreenStackAnimationProcessor() }

    return stackAnimation(
        selector = processor::process
    )
}