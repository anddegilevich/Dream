package and.degilevich.dream.widget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class DreamWidgetReceiver: GlanceAppWidgetReceiver()  {
    override val glanceAppWidget: GlanceAppWidget = DreamWidget()
}