package and.degilevich.dream.shared.feature.artist.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.ArtistEntity
import and.degilevich.dream.shared.feature.artist.data.mapper.api.local.SimplifiedArtistDataToEntityMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedArtistDataToEntityMapper(
    private val onMap: (SimplifiedArtistData) -> ArtistEntity = { fakeImplementationError() }
) : SimplifiedArtistDataToEntityMapper {

    override fun map(item: SimplifiedArtistData): ArtistEntity = onMap(item)
}