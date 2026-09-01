package and.degilevich.dream.shared.feature.playlist.ui.impl.mapper

import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.TrackDataToPlaylistTrackCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardInfoUIDataMapper

internal class TrackDataToPlaylistTrackCardUIDataMapperImpl(
    private val trackInfoToTrackCardInfoUIDataMapper: TrackInfoToTrackCardInfoUIDataMapper
) : TrackDataToPlaylistTrackCardUIDataMapper {

    override fun map(item: TrackData): PlaylistTrackCardUIData = with(item) {
        PlaylistTrackCardUIData(
            id = id,
            number = trackNumber.toString(),
            info = trackInfoToTrackCardInfoUIDataMapper.map(item),
            albumCoverUrl = album.images.firstOrNull()?.url.orEmpty()
        )
    }
}
