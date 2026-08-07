package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ArtistObject
import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject

fun artistObject(
    images: List<ImageObject> = emptyList()
): ArtistObject = ArtistObject(
    externalUrls = ExternalUrlObject(),
    href = "https://api.spotify.com/v1/artists/1",
    id = "artist-id",
    images = images,
    name = "Artist Name",
    type = ArtistObject.Type.ARTIST,
    uri = "spotify:artist:1"
)
