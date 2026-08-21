package and.degilevich.dream.shared.feature.artist.model.core.test.data

import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.ArtistId
import and.degilevich.dream.shared.feature.artist.model.artifact.api.dictionary.ArtistType
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData

fun artistData(
    id: String,
    artistType: ArtistType = ArtistType.ARTIST,
    images: List<ImageData> = emptyList()
): ArtistData = ArtistData(
    id = ArtistId(value = id),
    name = "Artist $id",
    artistType = artistType,
    images = images
)
