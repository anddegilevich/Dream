package and.degilevich.dream.shared.feature.artist.model.artifact

import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import and.degilevich.dream.shared.foundation.model.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.model.id.Identified

interface ArtistSimplifiedData : Identified, EmptyState {
    val name: String
    val type: ArtistType

    data class Base(
        override val id: String,
        override val name: String,
        override val type: ArtistType
    ) : ArtistSimplifiedData, AbstractIdentified()

    companion object : EmptyFactory<ArtistSimplifiedData> {
        override fun empty(): ArtistSimplifiedData {
            return Base(
                id = "",
                name = "",
                type = ArtistType.UNKNOWN
            )
        }
    }
}