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
import com.arkivanov.decompose.retainedComponent

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(Color.TRANSPARENT)
        )
        super.onCreate(savedInstanceState)

        val rootComponent = retainedComponent { componentContext ->
            RootComponentImpl(
                componentContext = componentContext
            )
        }
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