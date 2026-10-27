package and.degilevich.dream.shared.feature.search.domain.model.core.test.method.search

import and.degilevich.dream.shared.feature.artist.domain.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.artist.domain.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.domain.model.core.api.method.search.SearchArtistsData

fun searchArtistsData(
    items: List<ArtistData> = listOf(artistData(id = "artist-1")),
    total: Int = items.size
): SearchArtistsData = SearchArtistsData(
    items = items,
    total = total
)
