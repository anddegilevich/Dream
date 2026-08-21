package and.degilevich.dream.shared.feature.album.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PagingSimplifiedTrackObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumTracksOutputToDataMapper(
    private val onMap: (PagingSimplifiedTrackObject) -> AlbumTracksData = { fakeImplementationError() }
) : AlbumTracksOutputToDataMapper {

    override fun map(item: PagingSimplifiedTrackObject): AlbumTracksData = onMap(item)
}
