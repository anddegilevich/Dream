package and.degilevich.dream.shared.widget.design

import android.annotation.SuppressLint
import androidx.glance.text.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

@Suppress("ModifierMissing")
@SuppressLint("RestrictedApi")
@Composable
actual fun ComposeWidget() {
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Test widget",
            style = TextStyle(
                color = ColorProvider(Color.Black)
            )
        )
    }
}