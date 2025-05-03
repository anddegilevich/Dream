package and.degilevich.dream.widget

import and.degilevich.dream.shared.widget.design.ComposeWidget
import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent

class DreamWidget : GlanceAppWidget() {
    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        provideContent {
            ComposeWidget()
        }
    }
}