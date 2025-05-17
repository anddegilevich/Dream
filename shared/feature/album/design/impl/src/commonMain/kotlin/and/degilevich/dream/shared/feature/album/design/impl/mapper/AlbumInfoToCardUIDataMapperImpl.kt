package and.degilevich.dream.shared.feature.album.design.impl.mapper

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo

internal class AlbumInfoToCardUIDataMapperImpl : AlbumInfoToCardUIDataMapper {
    override fun map(
        album: AlbumInfo,
        isEnabled: Boolean
    ): AlbumCardUIData {
        return with(album) {
            AlbumCardUIData(
                id = id,
                iconUrl = images.firstOrNull()?.url.orEmpty(),
                name = name,
                artists = buildString {
                    artists.forEach { artist ->
                        if (isNotEmpty()) {
                            append(" . ")
                        }
                        append(artist)
                    }
                },
                isEnabled = isEnabled
            )
        }
    }
}