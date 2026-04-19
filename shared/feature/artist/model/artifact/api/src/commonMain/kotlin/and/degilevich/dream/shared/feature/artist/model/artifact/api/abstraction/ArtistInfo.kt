package and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.foundation.abstraction.id.Identified

interface ArtistInfo : Identified {
    override val id: ArtistId
    val name: String
    val artistType: ArtistType
}