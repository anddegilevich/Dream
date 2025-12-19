package and.degilevich.dream.shared.feature.track.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsInfoLayoutUIData
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class TrackDetailsInfoLayoutUIDataPreviewProvider : PreviewParameterProvider<TrackDetailsInfoLayoutUIData> {

    override val values: Sequence<TrackDetailsInfoLayoutUIData> = sequenceOf(
        provide()
    )

    fun provide(): TrackDetailsInfoLayoutUIData {
        return TrackDetailsInfoLayoutUIData.empty().copy(
            album = "Album",
            name = "Track",
            artists = "Artist"
        )
    }
}