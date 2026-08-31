package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedPlaylistObject
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.PlaylistId
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class SimplifiedPlaylistOutputToDataMapperImpl(
    private val imageOutputToDataMapper: ImageOutputToDataMapper
) : SimplifiedPlaylistOutputToDataMapper {

    override fun map(item: SimplifiedPlaylistObject): SimplifiedPlaylistData = with(item) {
        SimplifiedPlaylistData(
            id = id.orEmpty().let(::PlaylistId),
            name = name.orEmpty(),
            description = description.orEmpty(),
            totalTracks = items?.total ?: EMPTY_TOTAL_TRACKS,
            images = images.orEmpty().mapWith(imageOutputToDataMapper)
        )
    }

    private companion object {
        const val EMPTY_TOTAL_TRACKS = 0
    }
}
