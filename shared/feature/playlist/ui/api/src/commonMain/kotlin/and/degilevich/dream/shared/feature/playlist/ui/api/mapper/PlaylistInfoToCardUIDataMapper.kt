package and.degilevich.dream.shared.feature.playlist.ui.api.mapper

import and.degilevich.dream.shared.feature.playlist.model.artifact.api.abstraction.PlaylistInfo
import and.degilevich.dream.shared.feature.playlist.ui.api.model.PlaylistCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaylistInfoToCardUIDataMapper : Mapper<PlaylistInfo, PlaylistCardUIData>
