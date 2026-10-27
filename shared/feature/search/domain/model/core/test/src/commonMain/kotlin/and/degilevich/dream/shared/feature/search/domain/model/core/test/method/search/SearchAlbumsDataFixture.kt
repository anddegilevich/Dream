package and.degilevich.dream.shared.feature.search.domain.model.core.test.method.search

import and.degilevich.dream.shared.feature.album.domain.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.domain.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.search.domain.model.core.api.method.search.SearchAlbumsData

fun searchAlbumsData(
    items: List<SimplifiedAlbumData> = listOf(simplifiedAlbumData(id = "album-1")),
    total: Int = items.size
): SearchAlbumsData = SearchAlbumsData(
    items = items,
    total = total
)
