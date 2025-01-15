package and.degilevich.dream

import and.degilevich.dream.shared.app.SharedApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SharedApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    SharedApp()
}