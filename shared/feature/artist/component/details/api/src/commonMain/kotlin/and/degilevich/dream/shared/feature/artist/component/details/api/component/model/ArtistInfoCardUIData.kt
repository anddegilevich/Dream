package and.degilevich.dream.shared.feature.artist.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory

data class ArtistInfoCardUIData(
    val iconUrl: String,
    val name: String,
) {
    companion object Companion : EmptyFactory<ArtistInfoCardUIData> {
        override fun empty(): ArtistInfoCardUIData {
            return ArtistInfoCardUIData(
                iconUrl = "",
                name = ""
            )
        }
    }
}