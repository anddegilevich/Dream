package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState

object ArtistDetailsUIStatePreviewProvider {

    fun provide(): ArtistDetailsUIState {
        return ArtistDetailsUIState(
            name = "Artist",
            iconUrl = ""
        )
    }
}