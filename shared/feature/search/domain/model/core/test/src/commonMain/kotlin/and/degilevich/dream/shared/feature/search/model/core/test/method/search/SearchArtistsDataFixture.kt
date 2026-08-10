package and.degilevich.dream.shared.feature.search.model.core.test.method.search

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchArtistsData

fun searchArtistsData(
    items: List<ArtistData> = listOf(artistData(id = "artist-1"))
): SearchArtistsData = SearchArtistsData(
    items = items
)
