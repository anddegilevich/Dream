package and.degilevich.dream.shared.feature.player.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CurrentlyPlayingContextObject
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaybackStateOutputToDataMapper : Mapper<CurrentlyPlayingContextObject, PlaybackStateData>
