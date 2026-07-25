package and.degilevich.dream.shared.feature.artist.model.artifact.test.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType

fun simplifiedArtistData(id: String = "artist-1"): SimplifiedArtistData = SimplifiedArtistData(
    id = ArtistId(value = id),
    name = "Artist $id",
    artistType = ArtistType.ARTIST
)
