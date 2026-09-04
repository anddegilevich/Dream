package and.degilevich.dream.shared.feature.playlist.ui.api.mapper

import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistTrackCardUIData
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface TrackDataToPlaylistTrackCardUIDataMapper : Mapper<TrackData, PlaylistTrackCardUIData>
