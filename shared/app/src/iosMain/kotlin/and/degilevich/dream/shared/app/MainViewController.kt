package and.degilevich.dream.shared.app

import and.degilevich.dream.shared.app.root.RootComponentImpl
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun MainViewController() = ComposeUIViewController {
    val lifecycle = LifecycleRegistry()
    val rootComponent = RootComponentImpl(
        componentContext = DefaultComponentContext(
            lifecycle = lifecycle
        )
    )

    DreamApp(
        rootComponent = rootComponent
    )
}