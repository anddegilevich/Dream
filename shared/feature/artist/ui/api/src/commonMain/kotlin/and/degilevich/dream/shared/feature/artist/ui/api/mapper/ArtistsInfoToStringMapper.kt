package and.degilevich.dream.shared.feature.artist.ui.api.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.abstraction.ArtistInfo

interface ArtistsInfoToStringMapper {
    fun map(artists: List<ArtistInfo>): String
}