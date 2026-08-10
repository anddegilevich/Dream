package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ExternalUrlObject
import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject

fun simplifiedArtistObject(): SimplifiedArtistObject = SimplifiedArtistObject(
    externalUrls = ExternalUrlObject(),
    href = "https://api.spotify.com/v1/artists/1",
    id = "artist-id",
    name = "Artist Name",
    type = SimplifiedArtistObject.Type.ARTIST,
    uri = "spotify:artist:1"
)
