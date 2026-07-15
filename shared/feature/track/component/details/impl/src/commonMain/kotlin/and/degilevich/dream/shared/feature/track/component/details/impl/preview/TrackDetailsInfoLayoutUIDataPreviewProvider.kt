package and.degilevich.dream.shared.feature.track.component.details.impl.preview

import and.degilevich.dream.shared.feature.track.component.details.impl.component.model.TrackDetailsInfoLayoutUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class TrackDetailsInfoLayoutUIDataPreviewProvider : LabeledPreviewParameterProvider<TrackDetailsInfoLayoutUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): TrackDetailsInfoLayoutUIData {
        return TrackDetailsInfoLayoutUIData.empty().copy(
            album = "Album",
            name = "Track",
            artists = "Artist"
        )
    }
}