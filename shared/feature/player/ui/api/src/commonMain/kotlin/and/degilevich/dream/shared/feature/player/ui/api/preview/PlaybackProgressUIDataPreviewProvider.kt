package and.degilevich.dream.shared.feature.player.ui.api.preview

import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class PlaybackProgressUIDataPreviewProvider : LabeledPreviewParameterProvider<PlaybackProgressUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Start" to PlaybackProgressUIData(fraction = 0f, elapsed = "0:00", remaining = "-3:45"),
        "Long" to PlaybackProgressUIData(fraction = 0.9f, elapsed = "1:02:03", remaining = "-6:54")
    )

    fun provideDefault(): PlaybackProgressUIData {
        return PlaybackProgressUIData(
            fraction = 0.25f,
            elapsed = "0:20",
            remaining = "-1:00"
        )
    }
}
