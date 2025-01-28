package and.degilevich.dream

import and.degilevich.dream.shared.app.api.compose.DreamApp
import and.degilevich.dream.shared.app.impl.component.RootComponentImpl
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = RootComponentImpl(
            componentContext = defaultComponentContext()
        )

        setContent {
            DreamApp(
                rootComponent = rootComponent
            )
        }
    }
}