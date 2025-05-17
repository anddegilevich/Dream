package and.degilevich.dream.shared.feature.artist.design.api.preview.provider

import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistCardUIData

object ArtistCardUIDataPreviewProvider {
    fun provide(): ArtistCardUIData {
        return ArtistCardUIData.empty().copy(
            name = "Artist"
        )
    }
}