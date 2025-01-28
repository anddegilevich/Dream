package and.degilevich.dream.shared.feature.artist.core.api.domain.holder

import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.filter.GetArtistsFilter
import and.degilevich.dream.shared.foundation.model.holder.ValueHolder

interface GetArtistsFilterHolder : ValueHolder<GetArtistsFilter> {
    suspend fun setQuery(query: String)
}