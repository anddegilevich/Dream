package and.degilevich.dream.shared.feature.player.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface PlayHistoryOutputToDataMapper : Mapper<PlayHistoryObject, PlayHistoryData>
