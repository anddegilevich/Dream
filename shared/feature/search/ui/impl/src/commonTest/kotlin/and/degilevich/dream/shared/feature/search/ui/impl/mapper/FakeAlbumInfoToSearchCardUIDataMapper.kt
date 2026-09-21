package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.search.ui.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeAlbumInfoToSearchCardUIDataMapper(
    private val onMap: (item: AlbumInfo) -> AlbumSearchCardUIData = { fakeImplementationError() }
) : AlbumInfoToSearchCardUIDataMapper {

    override fun map(item: AlbumInfo): AlbumSearchCardUIData = onMap(item)
}
