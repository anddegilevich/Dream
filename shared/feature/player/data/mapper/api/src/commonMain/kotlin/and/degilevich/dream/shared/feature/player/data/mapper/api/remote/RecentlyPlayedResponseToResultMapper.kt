package and.degilevich.dream.shared.feature.player.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface RecentlyPlayedResponseToResultMapper : Mapper<CursorPagingPlayHistoryObject, GetRecentlyPlayedResult>
