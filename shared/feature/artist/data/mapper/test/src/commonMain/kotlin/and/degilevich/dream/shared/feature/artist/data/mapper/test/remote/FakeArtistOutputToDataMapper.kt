package and.degilevich.dream.shared.feature.artist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ArtistObject
import and.degilevich.dream.shared.feature.artist.data.mapper.api.remote.ArtistOutputToDataMapper
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistOutputToDataMapper(
    private val onMap: (ArtistObject) -> ArtistData = { fakeImplementationError() }
) : ArtistOutputToDataMapper {

    override fun map(item: ArtistObject): ArtistData = onMap(item)
}
