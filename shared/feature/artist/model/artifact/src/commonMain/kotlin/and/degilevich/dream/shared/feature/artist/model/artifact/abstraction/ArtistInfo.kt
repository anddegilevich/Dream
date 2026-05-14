package and.degilevich.dream.shared.feature.artist.model.artifact.abstraction

import and.degilevich.dream.shared.feature.artist.model.artifact.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface ArtistInfo : Identified {
    override val id: ArtistId
    val name: String
    val artistType: ArtistType
}