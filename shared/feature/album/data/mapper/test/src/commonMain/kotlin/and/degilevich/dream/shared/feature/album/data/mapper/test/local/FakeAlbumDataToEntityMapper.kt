package and.degilevich.dream.shared.feature.album.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.AlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumDataToEntityMapper(
    private val onMap: (AlbumData) -> AlbumEntity = { fakeImplementationError() }
) : AlbumDataToEntityMapper {

    override fun map(item: AlbumData): AlbumEntity = onMap(item)
}