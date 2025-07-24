package and.degilevich.dream.shared.feature.track.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState

object TrackDetailsUIStatePreviewProvider {
    fun provide(): TrackDetailsUIState {
        return TrackDetailsUIState.empty().copy(
            album = "Album",
            name = "Track",
            artists = "Artist"
        )
    }
}