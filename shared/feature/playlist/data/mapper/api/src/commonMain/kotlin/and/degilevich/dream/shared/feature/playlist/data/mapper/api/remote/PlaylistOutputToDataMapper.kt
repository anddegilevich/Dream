package and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlaylistObject
import and.degilevich.dream.shared.feature.playlist.model.core.api.data.PlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaylistOutputToDataMapper : Mapper<PlaylistObject, PlaylistData>
