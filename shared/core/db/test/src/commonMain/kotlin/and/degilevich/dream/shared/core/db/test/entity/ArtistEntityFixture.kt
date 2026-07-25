package and.degilevich.dream.shared.core.db.test.entity

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity

fun artistEntity(id: String): ArtistEntity = ArtistEntity(
    id = id,
    name = "Artist $id",
    artistType = "artist"
)
