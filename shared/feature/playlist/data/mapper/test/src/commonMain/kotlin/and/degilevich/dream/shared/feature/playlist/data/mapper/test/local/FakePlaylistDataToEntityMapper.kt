package and.degilevich.dream.shared.feature.playlist.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.PlaylistEntity
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.PlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlaylistDataToEntityMapper(
    private val onMap: (PlaylistData) -> PlaylistEntity = { fakeImplementationError() }
) : PlaylistDataToEntityMapper {

    override fun map(item: PlaylistData): PlaylistEntity = onMap(item)
}
