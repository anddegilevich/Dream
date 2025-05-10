package and.degilevich.dream

import and.degilevich.dream.shared.app.api.design.ComposeApp
import and.degilevich.dream.shared.app.impl.component.RootComponentImpl
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollFactory
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {

    private val rootComponent by lazy {
        RootComponentImpl(
            componentContext = defaultComponentContext()
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setOnExitAnimationListener { splashScreen ->
                splashScreen.remove()
            }
        }
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT)
        )

        setContent {
            CompositionLocalProvider(
                LocalOverscrollFactory provides null
            ) {
                ComposeApp(
                    rootComponent = rootComponent
                )
            }
        }
    }
}