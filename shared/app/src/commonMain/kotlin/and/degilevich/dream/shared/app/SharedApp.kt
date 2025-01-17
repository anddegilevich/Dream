package and.degilevich.dream.shared.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dream.shared.app.generated.resources.Res
import dream.shared.app.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun SharedApp(
    modifier: Modifier = Modifier
) {
    MaterialTheme {
        var isVisibleContent by remember { mutableStateOf(false) }

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { isVisibleContent = !isVisibleContent }
            ) {
                Text(text = "Click me!")
            }
            AnimatedVisibility(isVisibleContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}