package and.degilevich.dream.shared.feature.artist.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.ArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistDataToEntityMapper(
    private val onMap: (ArtistData) -> ArtistEntity = { fakeImplementationError() }
) : ArtistDataToEntityMapper {

    override fun map(item: ArtistData): ArtistEntity = onMap(item)
}
