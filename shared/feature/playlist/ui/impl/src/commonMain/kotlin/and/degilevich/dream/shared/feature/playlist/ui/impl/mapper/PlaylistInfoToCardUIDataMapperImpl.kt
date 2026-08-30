package and.degilevich.dream.shared.feature.playlist.ui.impl.mapper

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.abstraction.PlaylistInfo
import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.PlaylistInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData

internal class PlaylistInfoToCardUIDataMapperImpl : PlaylistInfoToCardUIDataMapper {

    override fun map(item: PlaylistInfo): PlaylistCardUIData = with(item) {
        PlaylistCardUIData(
            id = id,
            iconUrl = images.firstOrNull()?.url.orEmpty(),
            name = name
        )
    }
}
