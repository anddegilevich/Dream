package and.degilevich.dream.shared.feature.search.model.core.test.method.search

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.search.model.core.api.method.search.SearchAlbumsData

fun searchAlbumsData(
    items: List<SimplifiedAlbumData> = listOf(simplifiedAlbumData(id = "album-1"))
): SearchAlbumsData = SearchAlbumsData(
    items = items
)
