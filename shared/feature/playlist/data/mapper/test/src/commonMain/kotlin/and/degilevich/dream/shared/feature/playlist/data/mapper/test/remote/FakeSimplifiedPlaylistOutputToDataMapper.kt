package and.degilevich.dream.shared.feature.playlist.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedPlaylistObject
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSimplifiedPlaylistOutputToDataMapper(
    private val onMap: (SimplifiedPlaylistObject) -> SimplifiedPlaylistData = { fakeImplementationError() }
) : SimplifiedPlaylistOutputToDataMapper {

    override fun map(item: SimplifiedPlaylistObject): SimplifiedPlaylistData = onMap(item)
}
