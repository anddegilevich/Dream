package and.degilevich.dream.shared.feature.player.ui.api.mapper

import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlaybackStateData
import and.degilevich.dream.shared.feature.player.ui.api.model.PlaybackProgressUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlaybackStateDataToPlaybackProgressUIDataMapper : Mapper<PlaybackStateData, PlaybackProgressUIData>
