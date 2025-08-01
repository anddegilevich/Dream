package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoLayoutUIData

object ArtistInfoLayoutUIDataPreviewProvider {

    fun provide(): ArtistInfoLayoutUIData {
        return ArtistInfoLayoutUIData(
            name = "Artist",
            iconUrl = "",
        )
    }
}