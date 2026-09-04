package and.degilevich.dream.shared.feature.player.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.CursorPagingPlayHistoryObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.RecentlyPlayedResponseToResultMapper
import and.degilevich.dream.shared.feature.player.model.core.api.method.getRecentlyPlayed.GetRecentlyPlayedResult
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeRecentlyPlayedResponseToResultMapper(
    private val onMap: (CursorPagingPlayHistoryObject) -> GetRecentlyPlayedResult = { fakeImplementationError() }
) : RecentlyPlayedResponseToResultMapper {

    override fun map(item: CursorPagingPlayHistoryObject): GetRecentlyPlayedResult = onMap(item)
}
