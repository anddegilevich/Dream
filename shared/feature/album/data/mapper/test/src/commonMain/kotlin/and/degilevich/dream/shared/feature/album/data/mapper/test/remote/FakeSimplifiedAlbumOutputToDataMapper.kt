package and.degilevich.dream.shared.feature.album.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.data.mapper.api.remote.SimplifiedAlbumOutputToDataMapper
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedAlbumOutputToDataMapper(
    private val onMap: (SimplifiedAlbumObject) -> SimplifiedAlbumData = { fakeImplementationError() }
) : SimplifiedAlbumOutputToDataMapper {

    override fun map(item: SimplifiedAlbumObject): SimplifiedAlbumData = onMap(item)
}
