package and.degilevich.dream.shared.feature.artist.core.impl.domain

import and.degilevich.dream.shared.feature.artist.core.api.domain.holder.GetArtistsFilterHolder
import and.degilevich.dream.shared.feature.artist.core.api.source.model.request.getArtists.filter.GetArtistsFilter
import and.degilevich.dream.shared.foundation.model.holder.AbstractValueHolder

internal class GetArtistsFilterHolderImpl : GetArtistsFilterHolder, AbstractValueHolder<GetArtistsFilter>(
    defaultValue = GetArtistsFilter()
) {
    override suspend fun setQuery(query: String) {
        setValue {
            currentValue.copy(
                query = query
            )
        }
    }
}