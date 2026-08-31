package and.degilevich.dream.shared.feature.playlist.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedPlaylistDataToEntityMapper(
    private val onMap: (SimplifiedPlaylistData) -> PlaylistEntity = { fakeImplementationError() }
) : SimplifiedPlaylistDataToEntityMapper {

    override fun map(item: SimplifiedPlaylistData): PlaylistEntity = onMap(item)
}
