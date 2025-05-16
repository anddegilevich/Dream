package and.degilevich.dream.shared.feature.album.design.api.mapper

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData

interface AlbumDataToCardUIDataMapper {
    fun map(
        album: AlbumData,
        isEnabled: Boolean
    ): AlbumCardUIData
}