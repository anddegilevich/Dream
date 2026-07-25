package and.degilevich.dream.shared.feature.artist.ui.test.mapper

import and.degilevich.dream.shared.feature.artist.model.artifact.api.abstraction.ArtistInfo
import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeArtistsInfoToStringMapper(
    private val onMap: (List<ArtistInfo>) -> String = { fakeImplementationError() }
) : ArtistsInfoToStringMapper {

    override fun map(artists: List<ArtistInfo>): String = onMap(artists)
}