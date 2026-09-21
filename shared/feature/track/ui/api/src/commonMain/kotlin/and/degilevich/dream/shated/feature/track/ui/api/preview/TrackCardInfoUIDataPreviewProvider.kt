package and.degilevich.dream.shated.feature.track.ui.api.preview

import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData

class TrackCardInfoUIDataPreviewProvider : LabeledPreviewParameterProvider<TrackCardInfoUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): TrackCardInfoUIData {
        return TrackCardInfoUIData(
            name = "Track",
            artists = "Artist"
        )
    }

    fun provide(index: Int): TrackCardInfoUIData {
        return TrackCardInfoUIData(
            name = "Track $index",
            artists = "Artist"
        )
    }
}
