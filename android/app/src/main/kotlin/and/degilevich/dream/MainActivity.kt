package and.degilevich.dream

import and.degilevich.dream.shared.app.api.compose.DreamApp
import and.degilevich.dream.shared.app.impl.component.RootComponentImpl
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )

        val rootComponent = RootComponentImpl(
            componentContext = defaultComponentContext()
        )

        setContent {
            CompositionLocalProvider(
                LocalOverscrollConfiguration provides null
            ) {
                DreamApp(
                    rootComponent = rootComponent
                )
            }
        }
    }
}