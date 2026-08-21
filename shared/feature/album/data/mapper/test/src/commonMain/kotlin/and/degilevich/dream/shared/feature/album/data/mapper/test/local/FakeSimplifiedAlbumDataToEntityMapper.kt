package and.degilevich.dream.shared.feature.album.data.mapper.test.local

import and.degilevich.dream.shared.core.db.api.entity.AlbumEntity
import and.degilevich.dream.shared.feature.album.data.mapper.api.local.SimplifiedAlbumDataToEntityMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedAlbumDataToEntityMapper(
    private val onMap: (SimplifiedAlbumData) -> AlbumEntity = { fakeImplementationError() }
) : SimplifiedAlbumDataToEntityMapper {

    override fun map(item: SimplifiedAlbumData): AlbumEntity = onMap(item)
}