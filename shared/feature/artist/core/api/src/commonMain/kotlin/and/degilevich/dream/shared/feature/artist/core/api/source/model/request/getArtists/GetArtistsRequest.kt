package and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists

import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.filter.GetArtistsFilter

data class GetArtistsRequest(
    val offset: Int = 0,
    val limit: Int = 10,
    val filter: GetArtistsFilter = GetArtistsFilter()
)
