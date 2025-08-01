package and.degilevich.dream.shared.feature.track.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsInfoLayoutUIData

object TrackDetailsInfoLayoutUIDataPreviewProvider {
    fun provide(): TrackDetailsInfoLayoutUIData {
        return TrackDetailsInfoLayoutUIData.empty().copy(
            album = "Album",
            name = "Track",
            artists = "Artist"
        )
    }
}