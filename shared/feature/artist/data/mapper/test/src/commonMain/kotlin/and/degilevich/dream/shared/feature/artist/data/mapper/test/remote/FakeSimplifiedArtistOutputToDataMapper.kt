package and.degilevich.dream.shared.feature.artist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedArtistObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.SimplifiedArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.artifact.api.data.SimplifiedArtistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedArtistOutputToDataMapper(
    private val onMap: (SimplifiedArtistObject) -> SimplifiedArtistData = { fakeImplementationError() }
) : SimplifiedArtistOutputToDataMapper {

    override fun map(item: SimplifiedArtistObject): SimplifiedArtistData = onMap(item)
}
