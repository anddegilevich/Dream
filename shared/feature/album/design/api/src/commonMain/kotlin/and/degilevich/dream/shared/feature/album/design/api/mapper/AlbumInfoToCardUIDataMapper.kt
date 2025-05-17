package and.degilevich.dream.shared.feature.album.design.api.mapper

import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo

interface AlbumInfoToCardUIDataMapper {
    fun map(
        album: AlbumInfo,
        isEnabled: Boolean
    ): AlbumCardUIData
}