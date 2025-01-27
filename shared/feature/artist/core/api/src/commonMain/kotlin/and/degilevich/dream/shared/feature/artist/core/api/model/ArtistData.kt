package and.degilevich.dream.shared.feature.artist.core.api.model

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified

data class ArtistData(
    override val id: String,
    val name: String
) : AbstractIdentified() {
    companion object : EmptyFactory<ArtistData> {
        override fun empty(): ArtistData {
            return ArtistData(
                id = "",
                name = ""
            )
        }
    }
}
