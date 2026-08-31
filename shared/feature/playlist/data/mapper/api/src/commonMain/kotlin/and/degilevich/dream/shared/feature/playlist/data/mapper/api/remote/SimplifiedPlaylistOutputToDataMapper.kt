package and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedPlaylistObject
import and.degilevich.dream.shared.feature.playlist.model.artifact.api.data.SimplifiedPlaylistData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedPlaylistOutputToDataMapper : Mapper<SimplifiedPlaylistObject, SimplifiedPlaylistData>
