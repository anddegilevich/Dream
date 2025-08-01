package and.degilevich.dream.shared.feature.artist.component.details.api.preview.provider

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoCardUIData

object ArtistInfoCardUIDataPreviewProvider {

    fun provide(): ArtistInfoCardUIData {
        return ArtistInfoCardUIData(
            name = "Artist",
            iconUrl = "",
        )
    }
}