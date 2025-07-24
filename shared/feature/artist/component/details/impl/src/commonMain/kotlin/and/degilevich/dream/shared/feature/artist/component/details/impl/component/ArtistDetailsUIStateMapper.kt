package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState> {

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState {
        return with(item) {
            ArtistDetailsUIState(
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                name = artist.name
            )
        }
    }
}