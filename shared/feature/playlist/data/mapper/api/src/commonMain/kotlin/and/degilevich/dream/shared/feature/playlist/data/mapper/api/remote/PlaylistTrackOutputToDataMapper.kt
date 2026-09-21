package and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistTrackObject
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistTrackData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaylistTrackOutputToDataMapper : Mapper<PlaylistTrackObject, PlaylistTrackData>
