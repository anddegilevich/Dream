package and.degilevich.dream.shared.app.impl

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.app.api.design.ComposeApp
import androidx.compose.ui.window.ComposeUIViewController

fun rootViewController(rootComponent: RootComponent) = ComposeUIViewController {
    ComposeApp(
        rootComponent = rootComponent
    )
}