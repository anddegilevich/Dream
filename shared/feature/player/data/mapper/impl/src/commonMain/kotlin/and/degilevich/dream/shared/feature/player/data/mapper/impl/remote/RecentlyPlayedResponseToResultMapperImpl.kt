package and.degilevich.dream.shared.feature.player.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class RecentlyPlayedResponseToResultMapperImpl(
    private val playHistoryOutputToDataMapper: PlayHistoryOutputToDataMapper
) : RecentlyPlayedResponseToResultMapper {

    override fun map(item: CursorPagingPlayHistoryObject): GetRecentlyPlayedResult = with(item) {
        GetRecentlyPlayedResult(
            items = items.orEmpty().mapWith(playHistoryOutputToDataMapper)
        )
    }
}
