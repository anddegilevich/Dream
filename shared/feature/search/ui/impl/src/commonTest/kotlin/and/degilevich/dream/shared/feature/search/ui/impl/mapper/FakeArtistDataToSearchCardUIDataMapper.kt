package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.feature.search.ui.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistDataToSearchCardUIDataMapper(
    private val onMap: (item: ArtistData) -> ArtistSearchCardUIData = { fakeImplementationError() }
) : ArtistDataToSearchCardUIDataMapper {

    override fun map(item: ArtistData): ArtistSearchCardUIData = onMap(item)
}
