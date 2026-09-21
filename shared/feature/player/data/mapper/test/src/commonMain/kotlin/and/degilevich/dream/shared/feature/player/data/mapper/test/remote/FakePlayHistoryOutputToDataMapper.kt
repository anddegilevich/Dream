package and.degilevich.dream.shared.feature.player.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PlayHistoryObject
import and.degilevich.dream.shared.feature.player.data.mapper.api.remote.PlayHistoryOutputToDataMapper
import and.degilevich.dream.shared.feature.player.model.core.api.data.PlayHistoryData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakePlayHistoryOutputToDataMapper(
    private val onMap: (PlayHistoryObject) -> PlayHistoryData = { fakeImplementationError() }
) : PlayHistoryOutputToDataMapper {

    override fun map(item: PlayHistoryObject): PlayHistoryData = onMap(item)
}
