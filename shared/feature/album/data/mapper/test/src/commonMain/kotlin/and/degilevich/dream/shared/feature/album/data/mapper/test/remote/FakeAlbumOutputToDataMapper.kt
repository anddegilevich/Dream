package and.degilevich.dream.shared.feature.album.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.AlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.AlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumOutputToDataMapper(
    private val onMap: (AlbumObject) -> AlbumData = { fakeImplementationError() }
) : AlbumOutputToDataMapper {

    override fun map(item: AlbumObject): AlbumData = onMap(item)
}
