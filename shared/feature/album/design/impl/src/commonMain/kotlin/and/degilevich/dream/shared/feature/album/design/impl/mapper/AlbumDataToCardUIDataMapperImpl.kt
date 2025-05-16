package and.degilevich.dream.shared.feature.album.design.impl.mapper

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumDataToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData

internal class AlbumDataToCardUIDataMapperImpl : AlbumDataToCardUIDataMapper {
    override fun map(
        album: AlbumData,
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